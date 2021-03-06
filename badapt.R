library(reshape2)
library(ggplot2)
library(RColorBrewer)

colors <- brewer.pal(6, "Paired")
mapped_colors <- c("full_throttle"=colors[5],"managed"=colors[3],"energy_saver"=colors[1])

dta <- read.table("dat/badapt_consumed.dat", sep="\t", head=T)

xvals <- c()
xlbls <- c()

for (i in 1:nrow(dta)) {
  xvals <- c(xvals,dta$xcord[i])
  lbl <- paste(dta$bench[i], dta$data[i], sep="_")
  xlbls <- c(xlbls,lbl)
}

dta$vj1 <- rep(c(0,0,0), length.out=18)
dta$vj2 <- rep(c(0,0,0), length.out=18)

pdf("battery_casing.pdf")

print(dta)

dta$vj2[1] <- 1
dta$vj2[2] <- 1

dta$vj1[6] <- -1
dta$vj1[12] <- 1

p <- ggplot(data=dta, aes(xcord)) +
     geom_bar(aes(y=full_throttle,fill="full_throttle"),
              stat="identity", 
              width=0.15) +
     geom_bar(aes(y=managed,fill="managed"), 
              stat="identity", 
              width=0.15) +
     geom_bar(aes(y=energy_saver,fill="energy_saver"), 
              stat="identity", 
              width=0.15) + 

     geom_text(aes(y=managed,label=mid_percent_saved,vjust=0+vj1),colour="blue4",size=5.5) +

     geom_text(aes(y=energy_saver,label=low_percent_saved,vjust=1.2+vj2),colour="red2",size=5.5) +

     scale_fill_manual(name="Boot Mode",values=mapped_colors) +
     xlim(-0.5,6) +
     xlab("Benchmark") +
     ylab("Energy") +
     theme_gray(base_size=16) +
     theme(
           axis.text=element_text(color="black"),
           axis.text.x=element_text(angle=60, hjust = 1), 
           legend.position="bottom",
           plot.margin=unit(c(0.2,0.5,0.0,0.0),"cm")) +
     scale_x_continuous(breaks=xvals,labels=xlbls) +
     ggtitle("Battery Casing Runs")


print(p)

dev.off()
  
#  +
#    geom_bar(data=timetable, aes(x=dateValues, y=inHospital),
#                        stat="identity", fill="grey", colour="blue")
