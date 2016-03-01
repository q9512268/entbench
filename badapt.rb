#!/usr/bin/env ruby

require 'terminal-table'

#$BENCH = {batik:"batik-1.7", jspider:"jspider", sunflow:"sunflow", findbugs:"findbugs-3.0.1-new", pagerank:"jung"}
$BENCH = {sunflow:"sunflow", batik:"batik", crypto:"crypto", monte_carlo:"monte_carlo", findbugs:"findbugs"}
$DIR   = "adapt_run"
$RUNS = [
  "run_sd_hc.txt",
  "run_sd_mc.txt",
  "run_sd_lc.txt",

  "run_md_hc.txt",
  "run_md_mc.txt",
  "run_md_lc.txt",

  "run_ld_hc.txt",
  "run_ld_mc.txt",
  "run_ld_lc.txt",
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

# Build table for runtime for each run
#timetable = {}
#$BENCH.each do |bench, path|
#  times = []
#  $RUNS.each do |run| 
#    m = File.open("./#{path}/#{$DIR}/#{run}").read().match(/Time:(.*)$/)
#    times << m[1].strip().split()[0]
#  end
#  timetable[bench] = times
#end

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

#  timedat = File.open("dat/badapt_#{bench}_time.dat", "w+")


#  timedat.write('title "High Battery" "Medium Battery" "Low Battery"')
#  timedat.write("\n")
#  for i in 0..2 do
#    timedat.write("#{$DATAS[i]} ")
#    for j in (i*3)...((i+1)*3) do
#      timedat.write("#{timetable[bench][j]} ")
#    end
#    timedat.write("\n")
#  end
end
