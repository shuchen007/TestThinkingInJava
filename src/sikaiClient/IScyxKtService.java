/**
 * IScyxKtService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package sikaiClient;

public interface IScyxKtService extends java.rmi.Remote {
    public java.lang.String jhcDailyData(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String trqAnnualOutput(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String trqMonthlyPlan(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String inLargeNetworks(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String pourTransmission(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String trqOutsourcing(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String petroleumProduction(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String trqJingJingQi(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String monthlyNaturalGasproDuction(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String drillingData(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String JSTscldt(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String JSZycldt(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String HGQtscdt(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String HGThscdt(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String CNJSNdbs(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String CNJSZjdt(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String CNJSZjrb(java.lang.String wellNo) throws java.rmi.RemoteException;
    public java.lang.String CNJSSydt(java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String CNJSSyrb(java.lang.String wellNo) throws java.rmi.RemoteException;
    public java.lang.String CNJSZjrbByDwdmRq(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String CNJSSyrbByDwdmRq(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String getScyxUnit() throws java.rmi.RemoteException;
    public java.lang.String trqAnnualOutputNew(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String trqMonthlyPlanNew(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String monthlyNaturalGasproDuctionNew(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String wellZjData(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
    public java.lang.String wellSjData(java.lang.String dwdm, java.lang.String date) throws java.rmi.RemoteException;
}
