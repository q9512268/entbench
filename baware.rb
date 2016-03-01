#!/usr/bin/env ruby

require 'terminal-table'

#$BENCH = {batik:"batik-1.7", jspider:"jspider", findbugs:"findbugs-3.0.1-new", pagerank:"jung"}
$BENCH = {sunflow:"sunflow", crypto:"crypto"}

$DIR   = "baware_run"
$RUNS = [
  "run_sd_hc.txt",
  "run_sd_hcu.txt",
  "run_sd_mc.txt",
  "run_sd_mcu.txt",
  "run_sd_lc.txt",
  "run_sd_lcu.txt",

  "run_md_hc.txt",
  "run_md_hcu.txt",
  "run_md_mc.txt",
  "run_md_mcu.txt",
  "run_md_lc.txt",
  "run_md_lcu.txt",

  "run_ld_hc.txt",
  "run_ld_hcu.txt",
  "run_ld_mc.txt",
  "run_ld_mcu.txt",
  "run_ld_lc.txt",
  "run_ld_lcu.txt"
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
