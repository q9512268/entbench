#!/usr/bin/env ruby

require 'terminal-table'

$BENCH = {
    sunflow:"sunflow", 
    crypto:"crypto", 
    camera:"camera", 
    video:"video", 
    batik:"batik", 
    javaboy:"javaboy"
}

$DIR   = "badapt_run"
$RUNS = [
  "run_sd_hc.txt",  #0
  "run_sd_mc.txt",  #1
  "run_sd_lc.txt",  #2

  "run_md_hc.txt",  #3
  "run_md_mc.txt",  #4
  "run_md_lc.txt",  #5

  "run_ld_hc.txt",  #6
  "run_ld_mc.txt",  #7
  "run_ld_lc.txt",  #8
  ]

$DATAS = ["small", "medium", "large"] 
$LITTLEGAP=0.2
$LARGEGAP=1

# Build table for energy consumed for each run
consumedtable = {}
normaltable = {}
$BENCH.each do |bench, path|
  energy = []
  nenergy = []
  maxe = 0.0
  $RUNS.each do |run| 
    m = File.open("./pi_bench/#{path}/#{$DIR}/#{run}").read().scan(/ERun.*:(.*)$/)
    e = 0.0
    for i in 1..m.length-1 do
      e += m[i][0].strip().split()[2].to_f
    end
    e = e / m.length.to_f
    maxe = e unless maxe > e 
    energy << e
  end
  nenergy = energy.map { |n| n / maxe }
  consumedtable[bench] = energy
  normaltable[bench] = nenergy
end

# Dump tables for gnuplot
consumeddat = File.open("pi_dat/badapt_consumed.dat", "w+")

consumeddat.write("xcord\tbench\tdata\tenergy_saver\tmanaged\tfull_throttle\tlow_percent_saved\tmid_percent_saved\n")

k = 0
$BENCH.each do |bench, path|
  for i in 0..2 do
    xcord = i*$LITTLEGAP+k*$LARGEGAP
    consumeddat.write("#{xcord}\t#{bench}\t#{$DATAS[i]}")
    for j in (((i+1)*3)-1).downto(i*3) do
      consumeddat.write("\t#{normaltable[bench][j]}")
    end

    top = (((i+1)*3)-1)
  
    saver = (((consumedtable[bench][top-2]-consumedtable[bench][top]) / consumedtable[bench][top-2]) * 100.0).round(2)
    managed = (((consumedtable[bench][top-2]-consumedtable[bench][top-1]) / consumedtable[bench][top-2]) * 100.0).round(2)

    if (managed-saver).abs <= 2.0 
      consumeddat.write("\t#{saver}%\t")
    else
      consumeddat.write("\t#{saver}%\t#{managed}%")
    end



    consumeddat.write("\n")
  end
  k += 1
end

consumeddat.close

# Dump energy consumed diff
rows = []
rowsp = []
rowse = []
$BENCH.each do |bench, path|
  ld_ft_m = consumedtable[bench][6]-consumedtable[bench][7]
  ld_ft_mp = (ld_ft_m / ((consumedtable[bench][6] + consumedtable[bench][7]) / 2.0)) * 100.0
  ld_ft_me = (ld_ft_m / consumedtable[bench][6]) * 100.0

  ld_ft_es = consumedtable[bench][6]-consumedtable[bench][8]
  ld_ft_esp = (ld_ft_es / ((consumedtable[bench][6] + consumedtable[bench][8]) / 2.0)) * 100.0
  ld_ft_ese = (ld_ft_es / consumedtable[bench][6]) * 100.0

  md_ft_m = consumedtable[bench][3]-consumedtable[bench][4]
  md_ft_mp = (md_ft_m / ((consumedtable[bench][3] + consumedtable[bench][4]) / 2.0)) * 100.0
  md_ft_me = (md_ft_m / consumedtable[bench][3]) * 100.0

  md_ft_es = consumedtable[bench][3]-consumedtable[bench][5]
  md_ft_esp = (md_ft_es / ((consumedtable[bench][3] + consumedtable[bench][5]) / 2.0)) * 100.0
  md_ft_ese = (md_ft_es / consumedtable[bench][3]) * 100.0

  sd_ft_m = consumedtable[bench][0]-consumedtable[bench][1]
  sd_ft_mp = (sd_ft_m / ((consumedtable[bench][0] + consumedtable[bench][1]) / 2.0)) * 100.0
  sd_ft_me = (sd_ft_m / consumedtable[bench][0]) * 100.0

  sd_ft_es = consumedtable[bench][0]-consumedtable[bench][2]
  sd_ft_esp = (sd_ft_es / ((consumedtable[bench][0] + consumedtable[bench][2]) / 2.0)) * 100.0
  sd_ft_ese = (sd_ft_es / consumedtable[bench][0]) * 100.0

  rows << [bench, ld_ft_m.round(2), ld_ft_es.round(2), md_ft_m.round(2), md_ft_es.round(2), sd_ft_m.round(2), sd_ft_es.round(2)]
  rowsp << [bench, ld_ft_mp.round(2), ld_ft_esp.round(2), md_ft_mp.round(2), md_ft_esp.round(2), sd_ft_mp.round(2), sd_ft_esp.round(2)]
  rowse << [bench, ld_ft_me.round(2), ld_ft_ese.round(2), md_ft_me.round(2), md_ft_ese.round(2), sd_ft_me.round(2), sd_ft_ese.round(2)]

  rows << :separator
  rowsp << :separator
  rowse << :separator
end

table = Terminal::Table.new :title => "Raw Difference", :headings => ["Bench", "ld:full-managed", "ld:full-saver", "md:full-managed", "md:full-saver", "sd:full-managed", "sd:full-saver"], :rows => rows
puts table

#table2 = Terminal::Table.new :title => "Percent Difference", :headings => ["Bench", "ld:full-managed", "ld:full-saver", "md:full-managed", "md:full-saver", "sd:full-managed", "sd:full-saver"], :rows => rowsp
#puts table2

table3 = Terminal::Table.new :title => "Percent Error (Against full-throttle)", :headings => ["Bench", "ld:full-managed", "ld:full-saver", "md:full-managed", "md:full-saver", "sd:full-managed", "sd:full-saver"], :rows => rowse
puts table3


