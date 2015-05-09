/**
 * Author : Rishi Gupta
 * 
 * This file is part of 'serial communication manager' library.
 *
 * The 'serial communication manager' is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * The 'serial communication manager' is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with serial communication manager. If not, see <http://www.gnu.org/licenses/>.
 */

package com.embeddedunveiled.serial;

/**
 * <p>This class encapsulate port handle, looper object, event listener, data listener and port name associated with a particular port.</p>
 */
public final class SerialComPortHandleInfo {

	private String mOpenedPortName = null;
	private long mPortHandle = -1;
	private SerialComLooper mLooper = null;
	private ISerialComEventListener mEventListener = null;
	private ISerialComDataListener mDataListener = null;

	public SerialComPortHandleInfo(String portName, long handle, SerialComLooper looper, ISerialComDataListener dataListener, ISerialComEventListener eventListener) {
		this.mOpenedPortName = portName;
		this.mPortHandle     = handle;
		this.mLooper = looper;
		this.mEventListener  = eventListener;
		this.mDataListener  = dataListener;
	}


	/** <p>Get the name of port associated with given handle Callers first find reference to this class object using given handle and then invoke this method.</p>*/	
	public String getOpenedPortName() {
		return mOpenedPortName;
	}

	/** <p>Set the name of port.</p>*/	
	public void setOpenedPortName(String portName) {
		this.mOpenedPortName = portName;
	}

	/** <p> Check if the corresponding port name exist. </p>*/
	public boolean containsPort(String portName) throws SerialComException {
		if(portName == null) {
			throw new SerialComException("containsPort()", SerialComErrorMapper.ERR_PORT_NAME_NULL);
		}
		if(mOpenedPortName != null) {
			if(portName.equals(mOpenedPortName)) {
				return true;
			}
		}
		return false;
	}

	/** <p>Returns handle to the opened port. </p>*/	
	public long getPortHandle() {
		return mPortHandle;
	}

	/** <p>Sets the handle of the port opened.</p>*/
	public void setPortHandle(long handle) {
		this.mPortHandle = handle;
	}

	/** <p>Check if the object of this class have this handle. </p>*/
	public boolean containsHandle(long handle) {
		if(handle == mPortHandle) {
			return true;
		}
		return false;
	}

	/** <p>Looper associated with this port, info and manipulation. </p>*/	
	public SerialComLooper getLooper() {
		return mLooper;
	}

	/** <p>Set the looper object that is associated with this handle.</p>*/
	public void setLooper(SerialComLooper looper) {
		this.mLooper = looper;
	}

	/** <p>Event listener associated with this port, info and manipulation. </p>*/	
	public ISerialComEventListener getEventListener() {
		return mEventListener;
	}

	/** <p> Set the event listener associated with this handle. </p> */
	public void setEventListener(ISerialComEventListener eventListener) {
		this.mEventListener  = eventListener;
	}

	/** <p> Check if there is already a registered event listener for this handle. </p> */
	public boolean containsEventListener(ISerialComEventListener eventListener) {
		if(eventListener == mEventListener) {
			return true;
		}
		return false;
	}

	/** <p>Data Listener associated with this port, info and manipulation.</p> */	
	public ISerialComDataListener getDataListener() {
		return mDataListener;
	}

	/** <p> Set the data listener for this handle. </p> */
	public void setDataListener(ISerialComDataListener dataListener) {
		this.mDataListener  = dataListener;
	}

	/** <p> Check if there already exist a data listener for this handle. </p> */
	public boolean containsDataListener(ISerialComDataListener dataListener) {
		if(dataListener == mDataListener) {
			return true;
		}
		return false;
	}
}