#!/usr/bin/env ruby
#
require 'date'
require 'time'

f = File.open("./badapt_8_4.log")
f.each_line do |line|
  parsed = line.strip().split()
  t = DateTime.parse(parsed[0] + " " + parsed[1])
  puts t.zone
  puts "#{parsed[0]} #{parsed[1]} #{t.to_time.to_i} #{parsed[2]} #{parsed[3]} #{parsed[4]} #{parsed[5]}"
  exit
end
