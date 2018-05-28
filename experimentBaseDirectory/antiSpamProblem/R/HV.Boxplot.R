postscript("HV.Boxplot.eps", horizontal=FALSE, onefile=FALSE, height=8, width=12, pointsize=10)
resultDirectory<-"../data"
qIndicator <- function(indicator, problem)
{
fileMOCell<-paste(resultDirectory, "MOCell", sep="/")
fileMOCell<-paste(fileMOCell, problem, sep="/")
fileMOCell<-paste(fileMOCell, indicator, sep="/")
MOCell<-scan(fileMOCell)

fileNSGAII<-paste(resultDirectory, "NSGAII", sep="/")
fileNSGAII<-paste(fileNSGAII, problem, sep="/")
fileNSGAII<-paste(fileNSGAII, indicator, sep="/")
NSGAII<-scan(fileNSGAII)

algs<-c("MOCell","NSGAII")
boxplot(MOCell,NSGAII,names=algs, notch = FALSE)
titulo <-paste(indicator, problem, sep=":")
title(main=titulo)
}
par(mfrow=c(1,1))
indicator<-"HV"
qIndicator(indicator, "antiSpamProblem")
