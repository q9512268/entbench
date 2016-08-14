library(reshape2)
library(ggplot2)
library(RColorBrewer)

dta <- read.table("dat/baware_consumed.dat", sep="\t", head=T)

colors <- brewer.pal(4, "Paired")
mapped_colors <- c("managed"=colors[2],"managed silent"=colors[1],"full_throttle"=colors[4], "full_throttle silent"=colors[3])

xvals <- c()
xlbls <- c()

for (i in 1:nrow(dta)) {
  xvals <- c(xvals,dta$xcord[i])
  lbl <- paste(dta$bench[i], dta$data[i], sep="_")
  xlbls <- c(xlbls,lbl)
}

pdf("battery_exception_saved.pdf")

p <- ggplot(data=dta, aes(xcord)) +
     geom_bar(aes(y=java_managed,fill="managed silent"),
              stat="identity", 
              width=0.15) +
     geom_bar(aes(y=ent_managed,fill="managed"), 
              stat="identity", 
              width=0.15) +


     geom_bar(aes(y=java_full,fill="full_throttle silent"),
              stat="identity", 
              width=0.15) +
     geom_bar(aes(y=ent_full,fill="full_throttle"), 
              stat="identity", 
              width=0.15) +

     geom_text(aes(y=ent_managed,label=percent_saved),vjust=-0.5,colour="red2",size=4) +

     geom_text(aes(y=ent_full,label=percent_saved),vjust=-2,colour="red2",size=4) +

     scale_fill_manual(name="Boot Mode",values=mapped_colors) +
     xlim(-0.5,6) +
     xlab("Benchmark and Data Mode") +
     ylab("Energy") +
     theme_gray(base_size=16) +
     theme(axis.text.x=element_text(angle=60, hjust = 1), 
           legend.position="bottom",
           plot.margin=unit(c(0.2,1.0,0.0,0.0),"cm")) +
     scale_x_continuous(breaks=xvals,labels=xlbls) +
     ggtitle("Battery Exception Relative Saved")


print(p)

dev.off()
  
