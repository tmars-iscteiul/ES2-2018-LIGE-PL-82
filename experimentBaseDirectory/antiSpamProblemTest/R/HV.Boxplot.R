postscript("HV.Boxplot.eps", horizontal=FALSE, onefile=FALSE, height=8, width=12, pointsize=10)
resultDirectory<-"../data"
qIndicator <- function(indicator, problem)
{
fileGDE3<-paste(resultDirectory, "GDE3", sep="/")
fileGDE3<-paste(fileGDE3, problem, sep="/")
fileGDE3<-paste(fileGDE3, indicator, sep="/")
GDE3<-scan(fileGDE3)

fileIBEA<-paste(resultDirectory, "IBEA", sep="/")
fileIBEA<-paste(fileIBEA, problem, sep="/")
fileIBEA<-paste(fileIBEA, indicator, sep="/")
IBEA<-scan(fileIBEA)

fileMOCell<-paste(resultDirectory, "MOCell", sep="/")
fileMOCell<-paste(fileMOCell, problem, sep="/")
fileMOCell<-paste(fileMOCell, indicator, sep="/")
MOCell<-scan(fileMOCell)

fileMOEAD<-paste(resultDirectory, "MOEAD", sep="/")
fileMOEAD<-paste(fileMOEAD, problem, sep="/")
fileMOEAD<-paste(fileMOEAD, indicator, sep="/")
MOEAD<-scan(fileMOEAD)

fileNSGAII<-paste(resultDirectory, "NSGAII", sep="/")
fileNSGAII<-paste(fileNSGAII, problem, sep="/")
fileNSGAII<-paste(fileNSGAII, indicator, sep="/")
NSGAII<-scan(fileNSGAII)

filePAES<-paste(resultDirectory, "PAES", sep="/")
filePAES<-paste(filePAES, problem, sep="/")
filePAES<-paste(filePAES, indicator, sep="/")
PAES<-scan(filePAES)

fileRandomSearch<-paste(resultDirectory, "RandomSearch", sep="/")
fileRandomSearch<-paste(fileRandomSearch, problem, sep="/")
fileRandomSearch<-paste(fileRandomSearch, indicator, sep="/")
RandomSearch<-scan(fileRandomSearch)

fileSMSEMOA<-paste(resultDirectory, "SMSEMOA", sep="/")
fileSMSEMOA<-paste(fileSMSEMOA, problem, sep="/")
fileSMSEMOA<-paste(fileSMSEMOA, indicator, sep="/")
SMSEMOA<-scan(fileSMSEMOA)

algs<-c("GDE3","IBEA","MOCell","MOEAD","NSGAII","PAES","RandomSearch","SMSEMOA")
boxplot(GDE3,IBEA,MOCell,MOEAD,NSGAII,PAES,RandomSearch,SMSEMOA,names=algs, notch = FALSE)
titulo <-paste(indicator, problem, sep=":")
title(main=titulo)
}
par(mfrow=c(1,1))
indicator<-"HV"
qIndicator(indicator, "antiSpamProblemTest")
