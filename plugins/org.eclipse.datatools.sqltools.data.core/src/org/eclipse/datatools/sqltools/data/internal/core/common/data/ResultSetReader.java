/*******************************************************************************
 * Copyright (c) 2001, 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package org.eclipse.datatools.sqltools.data.internal.core.common.data;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;


public class ResultSetReader {

	public static String toNormalString(BigDecimal decimalValue) {
		String sciValue=decimalValue.toString();
		if((sciValue!=null) && (sciValue.indexOf('E')!=-1)) //If Decimal value is in Scientific form
		{
				sciValue=sciValue.substring(sciValue.indexOf("E", 0)+1);
				String convertedString=decimalValue.unscaledValue().toString();
				sciValue=sciValue.startsWith("+")?sciValue.substring(1):sciValue;
				int precision=Integer.parseInt(sciValue);
				if(precision<0) {
					for(int i=0;i<Math.abs(precision);i++) {
						if(i==Math.abs(precision)-1)
							convertedString="0."+convertedString;
						else
							convertedString="0"+convertedString;
					}
				}
				else {
					while(precision-convertedString.length()+1 > 0) {
						convertedString+="0";
					}	
					convertedString+=".0";
				}
				return convertedString;
		}
		else
		{
			return sciValue;
		}
	}
    public static Object read(ResultSet rs, int column) throws SQLException, IOException {
        return read(rs, column, -1);
    }
    
    public static Object read(ResultSet rs, int column, int lobLimit) throws SQLException, IOException
    {

	    int type = rs.getMetaData().getColumnType(column+1);
	    
	    if (type==Types.OTHER)
	    	return rs.getString(column+1);
	    
	    if (type == Types.BIGINT) {
	    	return new BigIntegerFormat().parse(rs.getString(column+1));
	    }
	    
	    if (type == Types.LONGVARCHAR) {
	    	return rs.getString(column+1);
	    }
	    // Hui Cao: the following lines are added in 256090, but it requires
		// JDK1.5+, while DTP1.6 has to maintain JDK1.4.2 backward
		// compatibility. So commented it out.
		//	    if (type == Types.DECIMAL) {
	    //	return rs.getBigDecimal(column+1).toPlainString();
	    //}
	
	    Object o = rs.getObject(column+1);
	    if (o==null)
	        return null;
	    
	    // Some Vendor implementation of timestamp is
	    // not a subclass of java.sql.Timestamp
	    if (type == Types.TIMESTAMP &&
	    		! (o instanceof java.sql.Timestamp))
	    {
	    	return (rs.getString(column+1));
	    	    	
	    }	    
	    	    
	    if (o instanceof Blob)
	        return readBinaryStream( ((Blob)o).getBinaryStream(), lobLimit );
	    else if (o instanceof Clob)
	        return readCharacterString( ((Clob)o).getCharacterStream(), lobLimit );
	    else if (o instanceof BigDecimal)
	    	return toNormalString((BigDecimal)o);
	    else if (o instanceof String)
	    	// The presence of a null character in the result string causes the string to truncate. 
	    	// Replace it with an alternate character.  \uFFFD is the Unicode Replacement 
	    	// Character, used to replace a character whose value is unknown or unrepresentable.
	    	return ((String) o).replaceAll("\u0000", "\uFFFD");
	    return o;

    }

    
    protected static String readCharacterString(Reader r, int limit) throws SQLException, IOException
    {
        StringWriter w = new StringWriter();
        char[] buf = new char[256];
        int remaining = limit;
        for (int n = r.read(buf); n != -1; n = r.read(buf)) {
            w.write(buf, 0, n);
            if (limit!=-1) {
                remaining -= n;
                if (remaining<=0)
                    break;
            }
        }
        r.close();
        w.close();
        String s = w.toString();
        if (limit!=-1 && s.length()>limit)
            s = s.substring(0, limit);
        return s;
    }
    
    protected static Object readBinaryStream(InputStream is, int limit) throws SQLException, IOException
    {
        InputStream bis = new BufferedInputStream(is);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        for (int n=bis.read(); n!=-1; n=bis.read()) {
            os.write(n);
            if (limit!=-1) {
                limit--;
                if (limit<=0)
                    break;
            }
        }
        bis.close();
        byte[] bytes = os.toByteArray();
        os.close();
        return bytes;
    }
    
}
