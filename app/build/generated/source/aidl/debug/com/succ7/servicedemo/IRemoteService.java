/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: E:\\ASSpace\\AIDLRemoteServiceDemo\\app\\src\\main\\aidl\\com\\succ7\\servicedemo\\IRemoteService.aidl
 */
package com.succ7.servicedemo;
public interface IRemoteService extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.succ7.servicedemo.IRemoteService
{
private static final java.lang.String DESCRIPTOR = "com.succ7.servicedemo.IRemoteService";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.succ7.servicedemo.IRemoteService interface,
 * generating a proxy if needed.
 */
public static com.succ7.servicedemo.IRemoteService asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.succ7.servicedemo.IRemoteService))) {
return ((com.succ7.servicedemo.IRemoteService)iin);
}
return new com.succ7.servicedemo.IRemoteService.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_buyTiket:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.buyTiket();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_playBall:
{
data.enforceInterface(descriptor);
java.lang.String _result = this.playBall();
reply.writeNoException();
reply.writeString(_result);
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements com.succ7.servicedemo.IRemoteService
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public java.lang.String buyTiket() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_buyTiket, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
@Override public java.lang.String playBall() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_playBall, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_buyTiket = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_playBall = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
}
public java.lang.String buyTiket() throws android.os.RemoteException;
public java.lang.String playBall() throws android.os.RemoteException;
}
