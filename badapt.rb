#!/usr/bin/env ruby

require 'terminal-table'

#$BENCH = {batik:"batik-1.7", jspider:"jspider", sunflow:"sunflow", findbugs:"findbugs-3.0.1-new", pagerank:"jung"}
$BENCH = {sunflow:"sunflow", batik:"batik", crypto:"crypto", monte_carlo:"monte_carlo", findbugs:"findbugs"}
$DIR   = "adapt_run"
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

$DATAS = ['"small"', '"medium"', '"large"']

$SIZE  = $RUNS.length

# Build table for energy consumed for each run
consumedtable = {}
$BENCH.each do |bench, path|
  energy = []
  $RUNS.each do |run| 
    m = File.open("./#{path}/#{$DIR}/#{run}").read().scan(/ERun.*:(.*)$/)
    e = 0.0
    for i in 1..m.length-1 do
      e += m[i][0].strip().split()[2].to_f
    end
    energy << e / m.length.to_f
  end
  consumedtable[bench] = energy
end

# Dump tables for gnuplot
$BENCH.each do |bench, path|
  consumeddat = File.open("dat/badapt_#{bench}_consumed.dat", "w+")

  consumeddat.write('title "full-throttle" "mid-throttle" "energy-saver"')

  consumeddat.write("\n")
  for i in 0..2 do
    consumeddat.write("#{$DATAS[i]} ")
    for j in (i*3)...((i+1)*3) do
      consumeddat.write("#{consumedtable[bench][j]} ")
    end
    consumeddat.write("\n")
  end
end

# Dump energy consumed diff
rows = []
rowsp = []
$BENCH.each do |bench, path|
  ld_ft_m = consumedtable[bench][6]-consumedtable[bench][7]
  ld_ft_mp = (ld_ft_m / consumedtable[bench][6]) * 100.0
  ld_m_es = consumedtable[bench][7]-consumedtable[bench][8]
  ld_m_esp = (ld_ft_m / consumedtable[bench][7]) * 100.0

  md_ft_m = consumedtable[bench][3]-consumedtable[bench][4]
  md_ft_mp = (ld_ft_m / consumedtable[bench][3]) * 100.0
  md_m_es = consumedtable[bench][4]-consumedtable[bench][5]
  md_m_esp = (ld_ft_m / consumedtable[bench][4]) * 100.0

  sd_ft_m = consumedtable[bench][0]-consumedtable[bench][1]
  sd_ft_mp = (ld_ft_m / consumedtable[bench][0]) * 100.0
  sd_m_es = consumedtable[bench][1]-consumedtable[bench][2]
  sd_m_esp = (ld_ft_m / consumedtable[bench][2]) * 100.0

  rows << [bench, ld_ft_m, ld_m_es, md_ft_m, md_m_es, sd_ft_m, sd_m_es]
  rowsp << [bench, ld_ft_mp, ld_m_esp, md_ft_mp, md_m_esp, sd_ft_mp, sd_m_esp]

  rows << :separator
  rowsp << :separator
end

table = Terminal::Table.new :headings => ["Bench", "ld:full-managed", "ld:managed-saver", "md:full-managed", "md:managed-saver", "sd:full-managed", "sd:managed-saver"], :rows => rows
puts table

table2 = Terminal::Table.new :headings => ["Bench", "ld:full-managed", "ld:managed-saver", "md:full-managed", "md:managed-saver", "sd:full-managed", "sd:managed-saver"], :rows => rowsp

puts table2
