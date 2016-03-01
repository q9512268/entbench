#!/usr/bin/env ruby

require 'terminal-table'

#$BENCH = {batik:"batik-1.7", jspider:"jspider", findbugs:"findbugs-3.0.1-new", pagerank:"jung"}
$BENCH = {sunflow:"sunflow", crypto:"crypto"}

$DIR   = "baware_run"
$RUNS = [
  "run_sd_hc.txt",  # 0
  "run_sd_hcu.txt", # 1
  "run_sd_mc.txt",  # 2
  "run_sd_mcu.txt", # 3
  "run_sd_lc.txt",  # 4
  "run_sd_lcu.txt", # 5

  "run_md_hc.txt",  # 6
  "run_md_hcu.txt", # 7
  "run_md_mc.txt",  # 8
  "run_md_mcu.txt", # 9
  "run_md_lc.txt",  # 10
  "run_md_lcu.txt", # 11

  "run_ld_hc.txt",  # 12
  "run_ld_hcu.txt", # 13
  "run_ld_mc.txt",  # 14
  "run_ld_mcu.txt", # 15
  "run_ld_lc.txt",  # 16
  "run_ld_lcu.txt"  # 17
  ]

$DATAS = ['"energy-saver"', '"managed"', '"full-throttle"']

$SIZE  = $RUNS.length

$PP = false
if ARGV.first == "-pp"
  $PP = true
end

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
    energy << e / (m.length-1).to_f
  end
  consumedtable[bench] = energy
end

# Dump tables for gnuplot
$BENCH.each do |bench, path|
  consumeddat = File.open("dat/baware_#{bench}_consumed.dat", "w+")

  consumeddat.write('title "full-throttle ent boot mode" "full-throttle silent boot mode" "managed ent boot mode" "managed silent  boot mode" "energy-saver ent boot mode" "energy-saver silent boot mode"')

  consumeddat.write("\n")
  for i in 0..2 do
    consumeddat.write("#{$DATAS[i]} ")
    for j in (i*6)...((i+1)*6) do
      consumeddat.write("#{consumedtable[bench][j]} ")
    end
    consumeddat.write("\n")
  end
end 

# Dump energy saved tables
puts "bench energy_saver/managed % managed/full_throttle % energy_saver/full_throttle %"
rows = []
$BENCH.each do |bench, path|
  es_m = consumedtable[bench][10] - consumedtable[bench][11]
  es_mp = (es_m / consumedtable[bench][10]) * 100.0

  m_ft = consumedtable[bench][14] - consumedtable[bench][15]
  m_ftp = (es_m / consumedtable[bench][14]) * 100.0

  es_ft = consumedtable[bench][16] - consumedtable[bench][17]
  es_ftp = (es_m / consumedtable[bench][16]) * 100.0
  
  rows << [bench, es_m, es_mp, m_ft, m_ftp, es_ft, es_ftp]
  rows << :separator
end

table = Terminal::Table.new :headings => ["Bench", "energy_saver/managed", "%", "managed/full_throttle", "%", "energy_saver/full_throttle", "%"], :rows => rows
puts table
