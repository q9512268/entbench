#!/usr/bin/env ruby

require 'terminal-table'

$BENCH = {
  sunflow:"sunflow", 
  jspider:"jspider", 
  crypto:"crypto", 
  findbugs:"findbugs", 
  pagerank:"pagerank",
  batik:"batik",
}

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

$DATAS = ["energy_saver", "managed", "full_throttle"]
$CONTEXTS = ['"full_throttle"', '"full_throttle silent"', '"managed"', '"managed silent"', '"energy_saver"', '"energy_saver silent"']

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
      e += m[i][0].strip().split()[0].to_f
    end
    energy << e / (m.length-1).to_f
  end
  consumedtable[bench] = energy
end

# Dump tables for gnuplot
$BENCH.each do |bench, path|
  consumeddat = File.open("dat/baware_#{bench}_consumed.dat", "w+")

  consumeddat.write("data\tcontext\tenergy\torder\n")

  for i in 0..2 do
    for j in (i*6)...((i+1)*6) do
      consumeddat.write("#{$DATAS[i]}\t#{$CONTEXTS[j%6]}\t#{consumedtable[bench][j]}\t#{(j%6)}\n")
    end
  end
end 

# Dump energy saved tables
rows = []
rowsp = []
rowse = []
$BENCH.each do |bench, path|
  p consumedtable[bench]

  es_m = consumedtable[bench][11] - consumedtable[bench][10]
  #es_mp = (es_m / ((consumedtable[bench][11] + consumedtable[bench][10]) / 2.0)) * 100.0
  es_me = (es_m / consumedtable[bench][11]) * 100.0

  m_ft = consumedtable[bench][15] - consumedtable[bench][14]
  #m_ftp = (m_ft / ((consumedtable[bench][15] + consumedtable[bench][14]) / 2.0)) * 100.0
  m_fte = (m_ft / consumedtable[bench][15]) * 100.0

  es_ft = consumedtable[bench][17] - consumedtable[bench][16]
  #es_ftp = (es_ft / ((consumedtable[bench][17] + consumedtable[bench][17]) / 2.0)) * 100.0
  es_fte = (es_ft / consumedtable[bench][17]) * 100.0
  
  rows << [bench, es_m.round(2), m_ft.round(2), es_ft.round(2)]
  #rowsp << [bench, es_mp.round(2), m_ftp.round(2), es_ftp.round(2)]
  rowse << [bench, es_me.round(2), m_fte.round(2), es_fte.round(2)]

  rows << :separator
  #rowsp << :separator
  rowse << :separator
end 

table = Terminal::Table.new :title => "Raw Difference", :headings => ["Bench", "saver-managed", "managed-full", "saver-full"], :rows => rows
puts table

#table2 = Terminal::Table.new :title => "Percent Difference", :headings => ["Bench", "saver-managed", "managed-full", "saver-full"], :rows => rowsp
#puts table2

table3 = Terminal::Table.new :title => "Percent Error (Against silent)", :headings => ["Bench", "saver-managed", "managed-full", "saver-full"], :rows => rowse
puts table3


