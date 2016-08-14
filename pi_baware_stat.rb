#!/usr/bin/env ruby

require 'terminal-table'

$BENCH = {
  sunflow:"sunflow", 
  crypto:"crypto", 
  camera:"camera", 
  video:"video",
  javaboy:"javaboy",
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

$SIZE_LABELS = ["small", "medium", "large"]
#$CONTXT_LABELS = ["-",  "full mean", "full dev", "full rel",
#                        "ufull mean", "ufull dev", "ufull rel",
#                        "managed mean", "managed dev", "managed rel", 
#                        "umanaged mean", "umanaged dev", "umanaged rel",
#                        "saver mean", "saver dev", "saver rel",
#                        "usaver mean", "usaver dev", "usaver rel" ]

$CONTXT_LABELS = ["-",  "full mean", "full rel",
                        "ufull mean",  "ufull rel",
                        "managed mean", "managed rel", 
                        "umanaged mean", "umanaged rel",
                        "saver mean", "saver rel",
                        "usaver mean", "usaver rel" ]


$CONTXT_LABELS2 = ["-", "f1d", "f2d", "f3d", "f4d", "",
                        "uf1d", "uf2d", "uf3d", "uf4d", "",

                        "m1d", "m2d", "m3d", "m4d", "",
                        "um1d", "um2d", "um3d", "um4d", "",

                        "s1d", "s2d", "s3d", "s4d", "",
                        "us1d", "us2d", "us3d", "us4d", ""]

# Go through and dump standard deviations for runs for each benchmark
totaltable = []
totals = [0,0,0,0]
reltotals = [0,0]
nonsmall_reltotals = [0,0]
total_runs = 0
$BENCH.each do |bench, path|
  dev_stat_rows = []
  dev_stat_cols = [$SIZE_LABELS[0]]
  dev_run_rows = []
  dev_run_cols = [$SIZE_LABELS[0]]

  bench_totals = [0,0,0,0]
  bench_total_runs = 0

  bench_reltotals = [0,0]
  nonsmall_bench_reltotals = [0,0]

  for i in 0..$RUNS.length-1 do
    puts "./pi_bench/#{path}/#{$DIR}/#{$RUNS[i]}"

    m = File.open("./pi_bench/#{path}/#{$DIR}/#{$RUNS[i]}").read().scan(/ERun.*:(.*)$/)

    next if i < 6 && bench == :javaboy


    energies = []
    for j in 1..m.length-1 do
      energies << m[j][0].strip().split()[2].to_f
    end
    total_runs += m.length-1
    bench_total_runs += m.length-1

    # Grab raw deviation statistics
    mean = energies.inject(:+) / (m.length.to_f-1)
    dev_stat_cols << mean.round(2)
    variance = energies.inject { |sum,n| sum + ((n - mean) ** 2) } / ((m.length-1).to_f)

    deviation = Math.sqrt(variance)
    #dev_stat_cols << deviation.round(2)
    rel_dev = ((deviation / mean) * 100.0).round(2)
    dev_stat_cols << rel_dev

    if (rel_dev < 2.0) then
      reltotals[0] += 1
      bench_reltotals[0] += 1
      if (i > 5) then
        nonsmall_bench_reltotals[0] += 1
        nonsmall_reltotals[0] += 1
      end
    end

    if (rel_dev < 3.0) then
      reltotals[1] += 1
      bench_reltotals[1] += 1
      if (i > 5) then
        nonsmall_bench_reltotals[1] += 1
        nonsmall_reltotals[1] += 1
      end
    end 
    
    # Check runs for within 1 and 2 deviations
    total_within = 0
    for j in 1..4 do
      rmin = mean - (deviation * j)
      rmax = mean + (deviation * j)
      within = 0
      energies.each do |e|
        within = within + 1 if (e >= rmin && e <= rmax)
      end
      within = within - total_within
      dev_run_cols << within
      total_within += within
      totals[j-1] += within
      bench_totals[j-1] += within
    end
    dev_run_cols << ""

    if ((i + 1) % 6 == 0) then
      dev_stat_rows << dev_stat_cols
      dev_stat_cols = [$SIZE_LABELS[(i+1)/6]]

      dev_run_rows << dev_run_cols
      dev_run_cols = [$SIZE_LABELS[(i+1)/6]]
    end
  end

  puts Terminal::Table.new :title => "#{bench} Deviation Statistics", 
    :headings => $CONTXT_LABELS, 
    :rows => dev_stat_rows
  puts "\n"

#  puts Terminal::Table.new :title => "#{bench} Deviation Runs", 
#    :headings => $CONTXT_LABELS2, 
#    :rows => dev_run_rows
#  puts "\n"

  dev1 = (bench_totals[0].to_f / bench_total_runs.to_f) * 100.0
  dev2 = (bench_totals[1].to_f / bench_total_runs.to_f) * 100.0
  dev3 = (bench_totals[2].to_f / bench_total_runs.to_f) * 100.0
  dev4 = (bench_totals[3].to_f / bench_total_runs.to_f) * 100.0

  totaltable << ["#{bench}",dev1.round(2),dev2.round(2),dev3.round(2),dev4.round(2), "", (dev1 + dev2).round(2)]

  puts "#{bench} Total Within 1 Deviation: #{dev1}"
  puts "#{bench} Total Within 2 Deviation: #{dev2}"
  puts "#{bench} Total Within 3 Deviation: #{dev3}"
  puts "#{bench} Total Within 4 Deviation: #{dev4}"
  puts "#{bench} Total Within 1 and 2 Deviation: #{dev1 + dev2}" 

  puts "#{bench} Total Within 2% Deviation: #{bench_reltotals[0]}"
  puts "#{bench} Total Within 3% Deviation: #{bench_reltotals[1]}"

  puts "#{bench} Nonsmall Total Within 2% Deviation: #{nonsmall_bench_reltotals[0]}"
  puts "#{bench} Nonsmall Total Within 3% Deviation: #{nonsmall_bench_reltotals[1]}"

  puts "#{bench} Nonsmall Percent Total Within 2% Deviation: #{(nonsmall_bench_reltotals[0]/12.0) * 100.0}"
  puts "#{bench} Nonsmall Percent Total Within 3% Deviation: #{(nonsmall_bench_reltotals[1]/12.0) * 100.0}"


  puts "\n"
end

puts Terminal::Table.new :title => "Overall Deviation Runs", 
    :headings => ["benchmark", "% within 1", "% within 2", "% within 3", "% within 4", "", "% within 1&2"],
    :rows => totaltable
puts "\n"

dev1 = (totals[0].to_f / total_runs.to_f) * 100.0
dev2 = (totals[1].to_f / total_runs.to_f) * 100.0
dev3 = (totals[2].to_f / total_runs.to_f) * 100.0
dev4 = (totals[3].to_f / total_runs.to_f) * 100.0

puts "All Total Within 1 Deviation: #{dev1}"
puts "All Total Within 2 Deviation: #{dev2}"
puts "All Total Within 3 Deviation: #{dev3}"
puts "All Total Within 4 Deviation: #{dev4}"
puts "All Total Within 1 and 2 Deviation: #{dev1 + dev2}"

puts "Nonsmall Percent Total Within 2% Deviation: #{(nonsmall_reltotals[0]/(12.0*5)) * 100.0}"
puts "Nonsmall Percent Total Within 3% Deviation: #{(nonsmall_reltotals[1]/(12.0*5)) * 100.0}"
