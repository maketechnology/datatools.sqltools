/*******************************************************************************
 * Copyright (c) 2004, 2005 Sybase, Inc. and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Sybase, Inc. - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.db.generic.parser;
import java.util.ArrayList;
import java.io.StringReader;
import org.eclipse.datatools.sqltools.db.generic.internal.GenericPlugin;
import org.eclipse.datatools.sqltools.sql.parser.SQLParser;
import org.eclipse.datatools.sqltools.sql.parser.ast.Node;
import org.eclipse.datatools.sqltools.sql.parser.ast.SimpleNode;
import org.eclipse.datatools.sqltools.sql.parser.ParseException;
import org.eclipse.datatools.sqltools.sql.parser.SQLParserConstants;
import org.eclipse.datatools.sqltools.sql.parser.JavaCharStream;
import org.eclipse.datatools.sqltools.sql.parser.Token;
import org.eclipse.datatools.sqltools.sql.parser.TokenMgrError;
import org.eclipse.datatools.sqltools.sql.parser.ParsingResult;
import org.eclipse.datatools.sqltools.sql.parser.util.ParserUtil;
import org.eclipse.datatools.sqltools.db.generic.internal.Messages;
import org.eclipse.datatools.sqltools.sql.parser.ParserParameters;

public class GenericSQLParserTokenManager implements GenericSQLParserConstants
{
            int commentNestingDepth = 0 ;
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1, long active2, long active3, long active4)
{
   switch (pos)
   {
      case 0:
         if ((active2 & 0x1ffe00000000L) != 0L)
         {
            jjmatchedKind = 210;
            return 73;
         }
         if ((active1 & 0x7e00000000000L) != 0L)
         {
            jjmatchedKind = 210;
            return 110;
         }
         if ((active0 & 0xffffe0000000L) != 0L)
         {
            jjmatchedKind = 210;
            return 204;
         }
         if ((active3 & 0x80000000L) != 0L)
            return 221;
         if ((active0 & 0x3fff000000000000L) != 0L)
         {
            jjmatchedKind = 210;
            return 59;
         }
         if ((active0 & 0xc00000001fffc000L) != 0L || (active1 & 0xfff81fffffffffffL) != 0L || (active2 & 0xffffe001ffffffffL) != 0L || (active3 & 0x7fL) != 0L)
         {
            jjmatchedKind = 210;
            return 222;
         }
         return -1;
      case 1:
         if ((active1 & 0x1c00000000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 1;
            }
            return 223;
         }
         if ((active2 & 0x3800000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 1;
            }
            return 72;
         }
         if ((active1 & 0x200000000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 1;
            }
            return 109;
         }
         if ((active0 & 0x180000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 1;
            }
            return 203;
         }
         if ((active0 & 0x400000000000000L) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 1;
            }
            return 58;
         }
         if ((active0 & 0xfbfffffe6fe3c000L) != 0L || (active1 & 0xcc061ffc00f9ffffL) != 0L || (active2 & 0xfffdffc7ffffffffL) != 0L || (active3 & 0x7fL) != 0L)
         {
            if (jjmatchedPos != 1)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 1;
            }
            return 222;
         }
         if ((active0 & 0x101c0000L) != 0L || (active1 & 0x33f80003ff060000L) != 0L || (active2 & 0x2000000000000L) != 0L)
            return 222;
         return -1;
      case 2:
         if ((active1 & 0x200000000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 2;
            }
            return 108;
         }
         if ((active0 & 0x400000000000000L) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 2;
            }
            return 57;
         }
         if ((active0 & 0x7bffffffefa08000L) != 0L || (active1 & 0x2f86d3eafcfdcffeL) != 0L || (active2 & 0xf3fdefcfffffffffL) != 0L || (active3 & 0x7fL) != 0L)
         {
            if (jjmatchedPos != 2)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 2;
            }
            return 222;
         }
         if ((active0 & 0x80000000004b4000L) != 0L || (active1 & 0xc0310c1400003001L) != 0L || (active2 & 0xc00103000000000L) != 0L)
            return 222;
         return -1;
      case 3:
         if ((active1 & 0x200000000000L) != 0L)
         {
            if (jjmatchedPos != 3)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 3;
            }
            return 107;
         }
         if ((active0 & 0x12bdffffa7a08000L) != 0L || (active1 & 0xa920d0427cf82f4fL) != 0L || (active2 & 0x73f12eec6ff8f1e2L) != 0L || (active3 & 0x4dL) != 0L)
         {
            if (jjmatchedPos != 3)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 3;
            }
            return 222;
         }
         if ((active0 & 0x400000000000000L) != 0L)
         {
            if (jjmatchedPos != 3)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 3;
            }
            return 56;
         }
         if ((active0 & 0x6942000048000000L) != 0L || (active1 & 0x68603a88005c0b0L) != 0L || (active2 & 0x880cc10390070e1dL) != 0L || (active3 & 0x32L) != 0L)
            return 222;
         return -1;
      case 4:
         if ((active0 & 0x400000000000000L) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 4;
            }
            return 45;
         }
         if ((active1 & 0x200000000000L) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 4;
            }
            return 106;
         }
         if ((active0 & 0x2bdeffc25200000L) != 0L || (active1 & 0x8924d00270e1296fL) != 0L || (active2 & 0x63b98eec6fbefd6aL) != 0L || (active3 & 0x41L) != 0L)
         {
            if (jjmatchedPos != 4)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 4;
            }
            return 222;
         }
         if ((active0 & 0x1000100382808000L) != 0L || (active1 & 0x200000400c180600L) != 0L || (active2 & 0x1040200000400080L) != 0L || (active3 & 0xcL) != 0L)
            return 222;
         return -1;
      case 5:
         if ((active1 & 0x200000000000L) != 0L)
         {
            if (jjmatchedPos != 5)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 5;
            }
            return 105;
         }
         if ((active0 & 0x29d4fed21200000L) != 0L || (active1 & 0x20c00260c12929L) != 0L || (active2 & 0x413986a0619edd6aL) != 0L || (active3 & 0x41L) != 0L)
         {
            if (jjmatchedPos != 5)
            {
               jjmatchedKind = 210;
               jjmatchedPos = 5;
            }
            return 222;
         }
         if ((active0 & 0x400000000000000L) != 0L)
            return 224;
         if ((active0 & 0x20a01004000000L) != 0L || (active1 & 0x8904100010200046L) != 0L || (active2 & 0x2280084c0e202000L) != 0L)
            return 222;
         return -1;
      case 6:
         if ((active1 & 0x200000000000L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 6;
            return 99;
         }
         if ((active0 & 0x285070d00200000L) != 0L || (active1 & 0xc00240c10908L) != 0L || (active2 & 0x1298680611e9d0aL) != 0L || (active3 & 0x40L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 6;
            return 222;
         }
         if ((active0 & 0x1848e021000000L) != 0L || (active1 & 0x20000020002021L) != 0L || (active2 & 0x4010002004804060L) != 0L || (active3 & 0x1L) != 0L)
            return 222;
         return -1;
      case 7:
         if ((active1 & 0x200000000000L) != 0L)
            return 225;
         if ((active0 & 0x84050500200000L) != 0L || (active1 & 0xc00240000808L) != 0L || (active2 & 0x108860001189d0aL) != 0L || (active3 & 0x40L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 7;
            return 222;
         }
         if ((active0 & 0x201020800000000L) != 0L || (active1 & 0xc10100L) != 0L || (active2 & 0x21008060060000L) != 0L)
            return 222;
         return -1;
      case 8:
         if ((active0 & 0x84050100200000L) != 0L || (active1 & 0xc00000000800L) != 0L || (active2 & 0x108060001181900L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 8;
            return 222;
         }
         if ((active0 & 0x400000000L) != 0L || (active1 & 0x240000008L) != 0L || (active2 & 0x80000000840aL) != 0L || (active3 & 0x40L) != 0L)
            return 222;
         return -1;
      case 9:
         if ((active0 & 0x80000000200000L) != 0L || (active1 & 0x800000000000L) != 0L || (active2 & 0x108000001081800L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 9;
            return 222;
         }
         if ((active0 & 0x4050100000000L) != 0L || (active1 & 0x400000000800L) != 0L || (active2 & 0x60000100100L) != 0L)
            return 222;
         return -1;
      case 10:
         if ((active0 & 0x80000000200000L) != 0L || (active1 & 0x800000000000L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 10;
            return 222;
         }
         if ((active2 & 0x108000001081800L) != 0L)
            return 222;
         return -1;
      case 11:
         if ((active0 & 0x80000000200000L) != 0L)
         {
            jjmatchedKind = 210;
            jjmatchedPos = 11;
            return 222;
         }
         if ((active1 & 0x800000000000L) != 0L)
            return 222;
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1, long active2, long active3, long active4)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1, active2, active3, active4), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         jjmatchedKind = 254;
         return jjMoveStringLiteralDfa1_0(0x2000L, 0x0L, 0x0L, 0x8000008000000000L, 0x1L);
      case 37:
         jjmatchedKind = 261;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x100000000L, 0x0L);
      case 38:
         return jjStopAtPos(0, 259);
      case 40:
         jjmatchedKind = 233;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x10000000000L, 0x0L);
      case 41:
         return jjStopAtPos(0, 234);
      case 42:
         jjmatchedKind = 235;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x1000000000000L, 0x0L);
      case 43:
         return jjStopAtPos(0, 237);
      case 44:
         return jjStopAtPos(0, 221);
      case 45:
         jjmatchedKind = 238;
         return jjMoveStringLiteralDfa1_0(0x40L, 0x0L, 0x0L, 0x0L, 0x0L);
      case 46:
         return jjStartNfaWithStates_0(0, 223, 221);
      case 47:
         jjmatchedKind = 236;
         return jjMoveStringLiteralDfa1_0(0x200L, 0x0L, 0x0L, 0x0L, 0x0L);
      case 58:
         return jjStopAtPos(0, 253);
      case 59:
         return jjStopAtPos(0, 222);
      case 60:
         jjmatchedKind = 226;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x800000000L, 0x2L);
      case 61:
         jjmatchedKind = 230;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x2000000000000L, 0x0L);
      case 62:
         jjmatchedKind = 228;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x4002000000000L, 0x0L);
      case 63:
         return jjStopAtPos(0, 239);
      case 94:
         return jjStopAtPos(0, 260);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa1_0(0x7fc000L, 0x0L, 0x0L, 0x0L, 0x0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa1_0(0x1f800000L, 0x0L, 0x0L, 0x0L, 0x0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa1_0(0xffffe0000000L, 0x0L, 0x0L, 0x0L, 0x0L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa1_0(0x3fff000000000000L, 0x0L, 0x0L, 0x0L, 0x0L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa1_0(0xc000000000000000L, 0x3ffL, 0x0L, 0x0L, 0x0L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1fc00L, 0x0L, 0x0L, 0x0L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1e0000L, 0x0L, 0x0L, 0x0L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x600000L, 0x0L, 0x0L, 0x0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x3ff800000L, 0x0L, 0x0L, 0x0L);
      case 74:
      case 106:
         return jjMoveStringLiteralDfa1_0(0x0L, 0xc00000000L, 0x0L, 0x0L, 0x0L);
      case 75:
      case 107:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x3000000000L, 0x0L, 0x0L, 0x0L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x3c000000000L, 0x0L, 0x0L, 0x0L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x1c0000000000L, 0x0L, 0x0L, 0x0L);
      case 78:
      case 110:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x7e00000000000L, 0x0L, 0x0L, 0x0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa1_0(0x0L, 0xfff8000000000000L, 0x1L, 0x0L, 0x0L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x3ffeL, 0x0L, 0x0L);
      case 81:
      case 113:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x4000L, 0x0L, 0x0L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x1ffff8000L, 0x0L, 0x0L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x1ffe00000000L, 0x0L, 0x0L);
      case 84:
      case 116:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x3fe00000000000L, 0x0L, 0x0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x1fc0000000000000L, 0x0L, 0x0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0xe000000000000000L, 0x0L, 0x0L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x7fL, 0x0L);
      case 124:
         jjmatchedKind = 258;
         return jjMoveStringLiteralDfa1_0(0x0L, 0x0L, 0x0L, 0x10000000L, 0x0L);
      case 126:
         return jjStopAtPos(0, 225);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0, long active1, long active2, long active3, long active4)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, active1, active2, active3, active4);
      return 1;
   }
   switch(curChar)
   {
      case 37:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000L, active1, 0L, active2, 0L, active3, 0L, active4, 0L);
      case 42:
         if ((active0 & 0x200L) != 0L)
            return jjStopAtPos(1, 9);
         else if ((active3 & 0x2000000000000L) != 0L)
            return jjStopAtPos(1, 241);
         break;
      case 43:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0L, active2, 0L, active3, 0x10000000000L, active4, 0L);
      case 45:
         if ((active0 & 0x40L) != 0L)
            return jjStopAtPos(1, 6);
         break;
      case 60:
         if ((active4 & 0x1L) != 0L)
            return jjStopAtPos(1, 256);
         break;
      case 61:
         if ((active3 & 0x800000000L) != 0L)
            return jjStopAtPos(1, 227);
         else if ((active3 & 0x2000000000L) != 0L)
            return jjStopAtPos(1, 229);
         else if ((active3 & 0x8000000000L) != 0L)
            return jjStopAtPos(1, 231);
         else if ((active3 & 0x1000000000000L) != 0L)
            return jjStopAtPos(1, 240);
         break;
      case 62:
         if ((active3 & 0x4000000000000L) != 0L)
            return jjStopAtPos(1, 242);
         else if ((active3 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 255);
         else if ((active4 & 0x2L) != 0L)
            return jjStopAtPos(1, 257);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x1000060000000L, active1, 0x240400200000L, active2, 0x6000200200008002L, active3, 0x1L, active4, 0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa2_0(active0, 0x2000000000000L, active1, 0L, active2, 0L, active3, 0L, active4, 0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0L, active2, 0x400000000L, active3, 0L, active4, 0L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000L, active1, 0x800000L, active2, 0L, active3, 0L, active4, 0L);
      case 69:
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0xfc000001800000L, active1, 0x5000000400L, active2, 0x1c0380fff000cL, active3, 0L, active4, 0L);
      case 70:
      case 102:
         if ((active1 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(1, 88, 222);
         else if ((active1 & 0x8000000000000L) != 0L)
         {
            jjmatchedKind = 115;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x30000000000000L, active2, 0L, active3, 0L, active4, 0L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x180000000L, active1, 0L, active2, 0xc000000000L, active3, 0xeL, active4, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa2_0(active0, 0x300000000000000L, active1, 0x8a000000800L, active2, 0x8000000000000000L, active3, 0x10L, active4, 0L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa2_0(active0, 0x4000000600008000L, active1, 0L, active2, 0x10L, active3, 0L, active4, 0L);
      case 78:
      case 110:
         if ((active1 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 89;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x40000000000000L) != 0L)
         {
            jjmatchedKind = 118;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x8000000000030000L, active1, 0x3800000fc000001L, active2, 0x1c0000000000000L, active3, 0L, active4, 0L);
      case 79:
      case 111:
         if ((active1 & 0x20000L) != 0L)
         {
            jjmatchedKind = 81;
            jjmatchedPos = 1;
         }
         else if ((active2 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 177, 222);
         return jjMoveStringLiteralDfa2_0(active0, 0x4001ff800000000L, active1, 0x1d30800443000L, active2, 0x100f0000000L, active3, 0x20L, active4, 0L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0xc00000000000000L, active2, 0x200000000000000L, active3, 0L, active4, 0L);
      case 82:
      case 114:
         if ((active1 & 0x1000000000000000L) != 0L)
         {
            jjmatchedKind = 124;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x800200006000000L, active1, 0x2000000000184000L, active2, 0x3c000000001fe0L, active3, 0x100000040L, active4, 0L);
      case 83:
      case 115:
         if ((active0 & 0x40000L) != 0L)
         {
            jjmatchedKind = 18;
            jjmatchedPos = 1;
         }
         else if ((active1 & 0x100000000L) != 0L)
         {
            jjmatchedKind = 96;
            jjmatchedPos = 1;
         }
         return jjMoveStringLiteralDfa2_0(active0, 0x80000L, active1, 0x200000002L, active2, 0x1c00000000000000L, active3, 0L, active4, 0L);
      case 84:
      case 116:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(1, 20, 222);
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0L, active2, 0xe0000000000L, active3, 0L, active4, 0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x3000c00008200000L, active1, 0xc006000000018000L, active2, 0x100100006000L, active3, 0L, active4, 0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa2_0(active0, 0x400000L, active1, 0x200L, active2, 0x1L, active3, 0L, active4, 0L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa2_0(active0, 0L, active1, 0x1fcL, active2, 0L, active3, 0L, active4, 0L);
      case 89:
      case 121:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(1, 28, 222);
         break;
      case 124:
         if ((active3 & 0x10000000L) != 0L)
            return jjStopAtPos(1, 220);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0, active1, active2, active3, active4);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3, long old4, long active4)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3) | (active4 &= old4)) == 0L)
      return jjStartNfa_0(0, old0, old1, old2, old3, old4); 
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, active1, active2, active3, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 41:
         if ((active3 & 0x10000000000L) != 0L)
            return jjStopAtPos(2, 232);
         break;
      case 94:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000L, active1, 0L, active2, 0L, active3, 0L);
      case 65:
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x4000800000000L, active1, 0x10000080000L, active2, 0xc024000070010L, active3, 0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0L, active2, 0x200000002000L, active3, 0L);
      case 67:
      case 99:
         if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(2, 19, 222);
         return jjMoveStringLiteralDfa3_0(active0, 0xa000000000000L, active1, 0x8002000000000eL, active2, 0x80000L, active3, 0L);
      case 68:
      case 100:
         if ((active0 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(2, 14, 222);
         else if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(2, 16, 222);
         else if ((active0 & 0x8000000000000000L) != 0L)
         {
            jjmatchedKind = 63;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x2000100004000001L, active2, 0x200000000000000L, active3, 0L);
      case 69:
      case 101:
         if ((active2 & 0x400000000000000L) != 0L)
         {
            jjmatchedKind = 186;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x200182000000L, active1, 0x400000000800230L, active2, 0x8800000000000021L, active3, 0x6L);
      case 70:
      case 102:
         if ((active1 & 0x10000000000000L) != 0L)
         {
            jjmatchedKind = 116;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x10000000000000L, active1, 0x20000000000000L, active2, 0x100000L, active3, 0L);
      case 71:
      case 103:
         if ((active0 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(2, 22, 222);
         return jjMoveStringLiteralDfa3_0(active0, 0x800000L, active1, 0L, active2, 0L, active3, 0L);
      case 72:
      case 104:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x400000000000L, active2, 0x400000000L, active3, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x8000000c0L, active2, 0x10d000000000c1c0L, active3, 0x49L);
      case 75:
      case 107:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x8000000000L, active2, 0L, active3, 0L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x20000008000000L, active1, 0x306002000400800L, active2, 0x2000000930000000L, active3, 0L);
      case 77:
      case 109:
         if ((active2 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 172, 222);
         return jjMoveStringLiteralDfa3_0(active0, 0x3000003000000000L, active1, 0L, active2, 0xc10000200000L, active3, 0L);
      case 78:
      case 110:
         if ((active1 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 107, 222);
         return jjMoveStringLiteralDfa3_0(active0, 0xfc000000000L, active1, 0x800000018000L, active2, 0L, active3, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x800000204000000L, active1, 0x208104000L, active2, 0x401e00L, active3, 0x100000000L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0L, active2, 0x100000001800000L, active3, 0L);
      case 82:
      case 114:
         if ((active1 & 0x1000L) != 0L)
         {
            jjmatchedKind = 76;
            jjmatchedPos = 2;
         }
         else if ((active1 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(2, 98, 222);
         return jjMoveStringLiteralDfa3_0(active0, 0xc00000000000L, active1, 0x2000L, active2, 0x40000c000000000eL, active3, 0x20L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x4340000060000000L, active1, 0x30000000L, active2, 0L, active3, 0L);
      case 84:
      case 116:
         if ((active1 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 112, 222);
         else if ((active1 & 0x4000000000000000L) != 0L)
         {
            jjmatchedKind = 126;
            jjmatchedPos = 2;
         }
         else if ((active2 & 0x1000000000L) != 0L)
         {
            jjmatchedKind = 164;
            jjmatchedPos = 2;
         }
         return jjMoveStringLiteralDfa3_0(active0, 0x81000001208000L, active1, 0x88002000c0040500L, active2, 0x2006000000L, active3, 0x10L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x400100400000000L, active1, 0L, active2, 0x20008000000000L, active3, 0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0x4000200000L, active2, 0x208000000L, active3, 0L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0L, active2, 0xc0000000L, active3, 0L);
      case 88:
      case 120:
         if ((active1 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 106, 222);
         return jjMoveStringLiteralDfa3_0(active0, 0L, active1, 0L, active2, 0x1000000000000L, active3, 0L);
      case 89:
      case 121:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(2, 17, 222);
         else if ((active1 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 100, 222);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(1, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, active1, active2, active3, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(3, 13);
         break;
      case 65:
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x11200002000000L, active1, 0x2L, active2, 0x300000000000000L, active3, 0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000000000L, active1, 0L, active2, 0L, active3, 0L);
      case 67:
      case 99:
         if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 49, 222);
         else if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 54, 222);
         else if ((active1 & 0x10L) != 0L)
         {
            jjmatchedKind = 68;
            jjmatchedPos = 3;
         }
         else if ((active1 & 0x8000L) != 0L)
         {
            jjmatchedKind = 79;
            jjmatchedPos = 3;
         }
         else if ((active2 & 0x200L) != 0L)
         {
            jjmatchedKind = 137;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x1a0000000L, active1, 0x800000010420L, active2, 0x40000c00L, active3, 0L);
      case 68:
      case 100:
         if ((active1 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 104, 222);
         else if ((active2 & 0x10000L) != 0L)
         {
            jjmatchedKind = 144;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x400000L, active2, 0x60000L, active3, 0L);
      case 69:
      case 101:
         if ((active0 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(3, 30, 222);
         else if ((active0 & 0x4000000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 62, 222);
         else if ((active1 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 103, 222);
         else if ((active1 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 119, 222);
         else if ((active2 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(3, 156, 222);
         else if ((active2 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(3, 160, 222);
         else if ((active2 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(3, 161, 222);
         else if ((active2 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 168, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0xa0000000008000L, active1, 0x2000004054002104L, active2, 0xc00104000L, active3, 0L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa4_0(active0, 0x4000000000L, active1, 0L, active2, 0L, active3, 0L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0L, active2, 0x10000000000000L, active3, 0L);
      case 72:
      case 104:
         if ((active3 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(3, 196, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L, active1, 0L, active2, 0L, active3, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x800000L, active1, 0x900300000200000L, active2, 0xc0000000000L, active3, 0L);
      case 75:
      case 107:
         if ((active0 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(3, 27, 222);
         else if ((active0 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 56, 222);
         else if ((active1 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 105, 222);
         else if ((active3 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(3, 197, 222);
         break;
      case 76:
      case 108:
         if ((active1 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 101, 222);
         else if ((active1 & 0x2000000000000L) != 0L)
         {
            jjmatchedKind = 113;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0xc000800000000L, active1, 0x4000200000808L, active2, 0x200021802000L, active3, 0x8L);
      case 77:
      case 109:
         if ((active1 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(3, 78, 222);
         else if ((active2 & 0x4L) != 0L)
         {
            jjmatchedKind = 130;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x1000001000000000L, active1, 0L, active2, 0x48L, active3, 0L);
      case 78:
      case 110:
         if ((active1 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(3, 99, 222);
         else if ((active1 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 122, 222);
         else if ((active2 & 0x10L) != 0L)
            return jjStartNfaWithStates_0(3, 132, 222);
         else if ((active2 & 0x4000000000000L) != 0L)
         {
            jjmatchedKind = 178;
            jjmatchedPos = 3;
         }
         else if ((active3 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(3, 193, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0x108000000000L, active1, 0x880200L, active2, 0x1028000000000080L, active3, 0L);
      case 79:
      case 111:
         if ((active1 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 82, 222);
         else if ((active1 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(3, 95, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x400000000000L, active2, 0x40000008280000L, active3, 0L);
      case 80:
      case 112:
         if ((active0 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 59, 222);
         else if ((active0 & 0x2000000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 61, 222);
         else if ((active2 & 0x400000000000L) != 0L)
         {
            jjmatchedKind = 174;
            jjmatchedPos = 3;
         }
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000L, active1, 0x8000000000000000L, active2, 0x800000000020L, active3, 0L);
      case 81:
      case 113:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0L, active2, 0x80000000000000L, active3, 0L);
      case 82:
      case 114:
         if ((active2 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(3, 128, 222);
         else if ((active2 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 187, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0x400000000000L, active1, 0L, active2, 0x4000400000L, active3, 0x4L);
      case 83:
      case 115:
         if ((active2 & 0x80000000L) != 0L)
            return jjStartNfaWithStates_0(3, 159, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0x810600000000L, active1, 0x20000000000040L, active2, 0x8000L, active3, 0L);
      case 84:
      case 116:
         if ((active1 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(3, 71, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0x200060000000000L, active1, 0x20000001L, active2, 0x1028000000002L, active3, 0x41L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0x8100000L, active2, 0x2000002006000000L, active3, 0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa4_0(active0, 0x80000000000L, active1, 0L, active2, 0x100L, active3, 0L);
      case 87:
      case 119:
         if ((active2 & 0x8000000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 191, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0x5000000L, active1, 0L, active2, 0L, active3, 0x100000000L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0L, active2, 0x1000L, active3, 0L);
      case 89:
      case 121:
         if ((active1 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 121, 222);
         return jjMoveStringLiteralDfa4_0(active0, 0L, active1, 0L, active2, 0x4000000000000000L, active3, 0L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(2, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, active1, active2, active3, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000020000000L, active1, 0x220000000L, active2, 0x800068L, active3, 0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa5_0(active0, 0x1000000000000L, active1, 0L, active2, 0x20000000L, active3, 0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0L, active2, 0x20000800000000L, active3, 0L);
      case 68:
      case 100:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0L, active2, 0x8000000000L, active3, 0L);
      case 69:
      case 101:
         if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(4, 33, 222);
         else if ((active2 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 173, 222);
         else if ((active3 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(4, 194, 222);
         else if ((active3 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(4, 195, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0x488801000000L, active1, 0x20000000000000L, active2, 0x2000004000008c00L, active3, 0x40L);
      case 70:
      case 102:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x100000000800L, active2, 0L, active3, 0x1L);
      case 71:
      case 103:
         if ((active2 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(4, 150, 222);
         else if ((active2 & 0x1000000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 188, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0L, active2, 0x10000000000000L, active3, 0L);
      case 72:
      case 104:
         if ((active1 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(4, 74, 222);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa5_0(active0, 0x200025000000000L, active1, 0x4000000002000L, active2, 0x4000020001002102L, active3, 0L);
      case 75:
      case 107:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(4, 25, 222);
         else if ((active0 & 0x80000000L) != 0L)
         {
            jjmatchedKind = 31;
            jjmatchedPos = 4;
         }
         return jjMoveStringLiteralDfa5_0(active0, 0x100000000L, active1, 0L, active2, 0x8000000L, active3, 0L);
      case 76:
      case 108:
         if ((active1 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 102, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0x404000000000000L, active1, 0xc00000400000L, active2, 0L, active3, 0L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0L, active2, 0x400000000L, active3, 0L);
      case 78:
      case 110:
         if ((active0 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(4, 23, 222);
         else if ((active2 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 182, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x100000000200000L, active2, 0x40000080000L, active3, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa5_0(active0, 0x800000200000L, active1, 0x800200000000000L, active2, 0x800040000000L, active3, 0L);
      case 80:
      case 112:
         if ((active1 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(4, 84, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0x6L, active2, 0x80000020000L, active3, 0L);
      case 82:
      case 114:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(4, 15, 222);
         else if ((active1 & 0x2000000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 125, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0x80040000000000L, active1, 0x50000101L, active2, 0x100000006100000L, active3, 0L);
      case 83:
      case 115:
         return jjMoveStringLiteralDfa5_0(active0, 0x4000000L, active1, 0L, active2, 0x9002000004000L, active3, 0L);
      case 84:
      case 116:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 44, 222);
         else if ((active1 & 0x200L) != 0L)
            return jjStartNfaWithStates_0(4, 73, 222);
         else if ((active1 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(4, 83, 222);
         else if ((active1 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(4, 91, 222);
         else if ((active2 & 0x80L) != 0L)
            return jjStartNfaWithStates_0(4, 135, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0x20210400000000L, active1, 0x810040L, active2, 0x200000000040000L, active3, 0x100000000L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa5_0(active0, 0x10002000000000L, active1, 0x8000000000000028L, active2, 0x80000000000000L, active3, 0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0L, active2, 0x200000L, active3, 0L);
      case 88:
      case 120:
         if ((active1 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(4, 90, 222);
         break;
      case 89:
      case 121:
         if ((active0 & 0x1000000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 60, 222);
         return jjMoveStringLiteralDfa5_0(active0, 0L, active1, 0L, active2, 0x1000L, active3, 0L);
      default :
         break;
   }
   return jjStartNfa_0(3, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(3, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, active1, active2, active3, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 95:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0L, active2, 0x1000L, active3, 0L);
      case 65:
      case 97:
         if ((active2 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(5, 162, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x1000000000000L, active1, 0x801L, active2, 0x28000020020000L, active3, 0L);
      case 67:
      case 99:
         if ((active2 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(5, 141, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000000L, active1, 0L, active2, 0x1804000L, active3, 0L);
      case 68:
      case 100:
         if ((active2 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 166, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x20000000L, active1, 0x400000000000L, active2, 0x400L, active3, 0L);
      case 69:
      case 101:
         if ((active0 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(5, 26, 222);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 45, 222);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 53, 222);
         else if ((active0 & 0x400000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 58, 224);
         else if ((active1 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(5, 65, 222);
         else if ((active1 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 120, 222);
         else if ((active2 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(5, 149, 222);
         else if ((active2 & 0x8000000L) != 0L)
            return jjStartNfaWithStates_0(5, 155, 222);
         else if ((active2 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 171, 222);
         else if ((active2 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 183, 222);
         else if ((active2 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 185, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x401000000L, active1, 0L, active2, 0x10002000140000L, active3, 0L);
      case 70:
      case 102:
         if ((active1 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 114, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0L, active2, 0x80000L, active3, 0L);
      case 71:
      case 103:
         if ((active1 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(5, 85, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x2000L, active2, 0x40000000000L, active3, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x810000L, active2, 0x1000000000000L, active3, 0L);
      case 76:
      case 108:
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000000000L, active1, 0x20000000L, active2, 0x100L, active3, 0L);
      case 77:
      case 109:
         return jjMoveStringLiteralDfa6_0(active0, 0x80000000000000L, active1, 0L, active2, 0L, active3, 0L);
      case 78:
      case 110:
         if ((active1 & 0x800000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 123, 222);
         else if ((active2 & 0x2000000L) != 0L)
         {
            jjmatchedKind = 153;
            jjmatchedPos = 5;
         }
         return jjMoveStringLiteralDfa6_0(active0, 0x200420000000000L, active1, 0x200000000100L, active2, 0x4000000004000008L, active3, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa6_0(active0, 0x4040000000000L, active1, 0x400000L, active2, 0x8000000000L, active3, 0x1L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa6_0(active0, 0x100000000L, active1, 0L, active2, 0L, active3, 0L);
      case 82:
      case 114:
         if ((active0 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 47, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x8094000200000L, active1, 0L, active2, 0x800000008060L, active3, 0L);
      case 83:
      case 115:
         if ((active1 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(5, 70, 222);
         else if ((active2 & 0x2000000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 189, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x800000000L, active1, 0x40000008L, active2, 0x20000000800L, active3, 0L);
      case 84:
      case 116:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 36, 222);
         else if ((active1 & 0x4L) != 0L)
            return jjStartNfaWithStates_0(5, 66, 222);
         else if ((active1 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(5, 92, 222);
         else if ((active1 & 0x8000000000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 127, 222);
         else if ((active2 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(5, 163, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0x2000000000L, active1, 0x20000200000020L, active2, 0x100000000000002L, active3, 0x40L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0x800000000000L, active2, 0x40000000L, active3, 0L);
      case 89:
      case 121:
         if ((active1 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 108, 222);
         return jjMoveStringLiteralDfa6_0(active0, 0L, active1, 0L, active2, 0L, active3, 0x100000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(4, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, active1, active2, active3, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa7_0(active0, 0x10000000000L, active1, 0x200000000100L, active2, 0x800001000000L, active3, 0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa7_0(active0, 0x204000800000000L, active1, 0x400800L, active2, 0x8000020000000L, active3, 0L);
      case 69:
      case 101:
         if ((active0 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(6, 29, 222);
         else if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 37, 222);
         else if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 51, 222);
         else if ((active1 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(6, 69, 222);
         else if ((active2 & 0x20L) != 0L)
            return jjStartNfaWithStates_0(6, 133, 222);
         else if ((active2 & 0x4000L) != 0L)
            return jjStartNfaWithStates_0(6, 142, 222);
         else if ((active2 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(6, 151, 222);
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x40000000L, active2, 0x108L, active3, 0x40L);
      case 71:
      case 103:
         if ((active2 & 0x4000000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 190, 222);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa7_0(active0, 0x80000000200000L, active1, 0x200000008L, active2, 0x100000000080002L, active3, 0L);
      case 76:
      case 108:
         if ((active1 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(6, 93, 222);
         return jjMoveStringLiteralDfa7_0(active0, 0x40000000000L, active1, 0x400000000000L, active2, 0L, active3, 0L);
      case 77:
      case 109:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 38, 222);
         break;
      case 78:
      case 110:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(6, 24, 222);
         else if ((active1 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(6, 64, 222);
         else if ((active1 & 0x2000L) != 0L)
            return jjStartNfaWithStates_0(6, 77, 222);
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0L, active2, 0x40100000L, active3, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa7_0(active0, 0x100000000L, active1, 0x10000L, active2, 0L, active3, 0L);
      case 80:
      case 112:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0L, active2, 0L, active3, 0x100000000L);
      case 82:
      case 114:
         if ((active2 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 165, 222);
         else if ((active2 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 180, 222);
         else if ((active3 & 0x1L) != 0L)
            return jjStartNfaWithStates_0(6, 192, 222);
         return jjMoveStringLiteralDfa7_0(active0, 0x400000000L, active1, 0L, active2, 0x8000L, active3, 0L);
      case 83:
      case 115:
         if ((active1 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 117, 222);
         else if ((active2 & 0x4000000L) != 0L)
            return jjStartNfaWithStates_0(6, 154, 222);
         return jjMoveStringLiteralDfa7_0(active0, 0x1000000000000L, active1, 0x800000000000L, active2, 0x40000020800L, active3, 0L);
      case 84:
      case 116:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 39, 222);
         else if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 43, 222);
         else if ((active0 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 46, 222);
         else if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(6, 52, 222);
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0x800000L, active2, 0x20020000001000L, active3, 0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa7_0(active0, 0x20000000000L, active1, 0L, active2, 0x400L, active3, 0L);
      case 87:
      case 119:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0L, active2, 0x8000000000L, active3, 0L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0L, active2, 0x40000L, active3, 0L);
      case 89:
      case 121:
         if ((active2 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(6, 134, 222);
         break;
      case 90:
      case 122:
         return jjMoveStringLiteralDfa7_0(active0, 0L, active1, 0L, active2, 0x1000000000000L, active3, 0L);
      default :
         break;
   }
   return jjStartNfa_0(5, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(5, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, active1, active2, active3, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa8_0(active0, 0x4000000000000L, active1, 0L, active2, 0x1000L, active3, 0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x40000000L, active2, 0x100000L, active3, 0L);
      case 69:
      case 101:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(7, 35, 222);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 41, 222);
         else if ((active0 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 48, 222);
         else if ((active2 & 0x1000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 176, 222);
         else if ((active2 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 181, 222);
         else if ((active3 & 0x100000000L) != 0L)
            return jjStopAtPos(7, 224);
         return jjMoveStringLiteralDfa8_0(active0, 0x400000000L, active1, 0L, active2, 0x800L, active3, 0L);
      case 71:
      case 103:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0L, active2, 0x80100L, active3, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa8_0(active0, 0x10100000000L, active1, 0L, active2, 0x60000000000L, active3, 0L);
      case 75:
      case 107:
         if ((active1 & 0x400000L) != 0L)
            return jjStartNfaWithStates_0(7, 86, 222);
         else if ((active2 & 0x20000000L) != 0L)
            return jjStartNfaWithStates_0(7, 157, 222);
         break;
      case 76:
      case 108:
         if ((active1 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(7, 72, 222);
         else if ((active1 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 109, 225);
         break;
      case 78:
      case 110:
         if ((active1 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(7, 80, 222);
         else if ((active2 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 167, 222);
         return jjMoveStringLiteralDfa8_0(active0, 0x80000000000000L, active1, 0L, active2, 0x8L, active3, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x400200000000L, active2, 0x8002L, active3, 0L);
      case 82:
      case 114:
         return jjMoveStringLiteralDfa8_0(active0, 0x40000000000L, active1, 0L, active2, 0x800000000400L, active3, 0L);
      case 84:
      case 116:
         if ((active0 & 0x200000000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 57, 222);
         else if ((active2 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(7, 145, 222);
         else if ((active2 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(7, 146, 222);
         else if ((active2 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(7, 158, 222);
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x800000000800L, active2, 0x108000001000000L, active3, 0L);
      case 86:
      case 118:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0x8L, active2, 0L, active3, 0L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa8_0(active0, 0L, active1, 0L, active2, 0L, active3, 0x40L);
      case 89:
      case 121:
         if ((active1 & 0x800000L) != 0L)
            return jjStartNfaWithStates_0(7, 87, 222);
         break;
      case 90:
      case 122:
         return jjMoveStringLiteralDfa8_0(active0, 0x200000L, active1, 0L, active2, 0L, active3, 0L);
      default :
         break;
   }
   return jjStartNfa_0(6, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa8_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(6, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(7, active0, active1, active2, active3, 0L);
      return 8;
   }
   switch(curChar)
   {
      case 65:
      case 97:
         return jjMoveStringLiteralDfa9_0(active0, 0x200000L, active1, 0L, active2, 0L, active3, 0L);
      case 66:
      case 98:
         return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0L, active2, 0x1000L, active3, 0L);
      case 67:
      case 99:
         return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0x400000000000L, active2, 0x20000000000L, active3, 0L);
      case 68:
      case 100:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(8, 34, 222);
         break;
      case 69:
      case 101:
         if ((active1 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(8, 67, 222);
         else if ((active2 & 0x400L) != 0L)
            return jjStartNfaWithStates_0(8, 138, 222);
         return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0x800000000000L, active2, 0x100100L, active3, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa9_0(active0, 0x80000000000000L, active1, 0L, active2, 0x108000001000000L, active3, 0L);
      case 78:
      case 110:
         if ((active1 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(8, 97, 222);
         else if ((active2 & 0x2L) != 0L)
            return jjStartNfaWithStates_0(8, 129, 222);
         return jjMoveStringLiteralDfa9_0(active0, 0x10100000000L, active1, 0L, active2, 0L, active3, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa9_0(active0, 0x40000000000L, active1, 0x800L, active2, 0L, active3, 0L);
      case 82:
      case 114:
         if ((active2 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(8, 143, 222);
         break;
      case 84:
      case 116:
         if ((active1 & 0x40000000L) != 0L)
            return jjStartNfaWithStates_0(8, 94, 222);
         else if ((active2 & 0x8L) != 0L)
            return jjStartNfaWithStates_0(8, 131, 222);
         else if ((active3 & 0x40L) != 0L)
            return jjStartNfaWithStates_0(8, 198, 222);
         return jjMoveStringLiteralDfa9_0(active0, 0x4000000000000L, active1, 0L, active2, 0L, active3, 0L);
      case 85:
      case 117:
         return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0L, active2, 0x80000L, active3, 0L);
      case 88:
      case 120:
         return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0L, active2, 0x800L, active3, 0L);
      case 89:
      case 121:
         if ((active2 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(8, 175, 222);
         break;
      case 90:
      case 122:
         return jjMoveStringLiteralDfa9_0(active0, 0L, active1, 0L, active2, 0x40000000000L, active3, 0L);
      default :
         break;
   }
   return jjStartNfa_0(7, active0, active1, active2, active3, 0L);
}
private final int jjMoveStringLiteralDfa9_0(long old0, long active0, long old1, long active1, long old2, long active2, long old3, long active3)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2) | (active3 &= old3)) == 0L)
      return jjStartNfa_0(7, old0, old1, old2, old3, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(8, active0, active1, active2, 0L, 0L);
      return 9;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active0 & 0x4000000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 50, 222);
         else if ((active2 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 170, 222);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0L, active2, 0x800L);
      case 75:
      case 107:
         if ((active1 & 0x400000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 110, 222);
         break;
      case 76:
      case 108:
         return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0L, active2, 0x1000L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0L, active2, 0x108000001000000L);
      case 82:
      case 114:
         if ((active1 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(9, 75, 222);
         return jjMoveStringLiteralDfa10_0(active0, 0L, active1, 0x800000000000L, active2, 0x80000L);
      case 83:
      case 115:
         if ((active2 & 0x100L) != 0L)
            return jjStartNfaWithStates_0(9, 136, 222);
         else if ((active2 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(9, 148, 222);
         else if ((active2 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 169, 222);
         return jjMoveStringLiteralDfa10_0(active0, 0x80000000000000L, active1, 0L, active2, 0L);
      case 84:
      case 116:
         if ((active0 & 0x100000000L) != 0L)
            return jjStartNfaWithStates_0(9, 32, 222);
         else if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 40, 222);
         return jjMoveStringLiteralDfa10_0(active0, 0x200000L, active1, 0L, active2, 0L);
      case 87:
      case 119:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(9, 42, 222);
         break;
      default :
         break;
   }
   return jjStartNfa_0(8, active0, active1, active2, 0L, 0L);
}
private final int jjMoveStringLiteralDfa10_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(8, old0, old1, old2, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(9, active0, active1, active2, 0L, 0L);
      return 10;
   }
   switch(curChar)
   {
      case 69:
      case 101:
         if ((active2 & 0x1000L) != 0L)
            return jjStartNfaWithStates_0(10, 140, 222);
         else if ((active2 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(10, 147, 222);
         return jjMoveStringLiteralDfa11_0(active0, 0L, active1, 0x800000000000L, active2, 0L);
      case 73:
      case 105:
         return jjMoveStringLiteralDfa11_0(active0, 0x200000L, active1, 0L, active2, 0L);
      case 78:
      case 110:
         if ((active2 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(10, 152, 222);
         else if ((active2 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(10, 179, 222);
         else if ((active2 & 0x100000000000000L) != 0L)
            return jjStartNfaWithStates_0(10, 184, 222);
         break;
      case 84:
      case 116:
         if ((active2 & 0x800L) != 0L)
            return jjStartNfaWithStates_0(10, 139, 222);
         return jjMoveStringLiteralDfa11_0(active0, 0x80000000000000L, active1, 0L, active2, 0L);
      default :
         break;
   }
   return jjStartNfa_0(9, active0, active1, active2, 0L, 0L);
}
private final int jjMoveStringLiteralDfa11_0(long old0, long active0, long old1, long active1, long old2, long active2)
{
   if (((active0 &= old0) | (active1 &= old1) | (active2 &= old2)) == 0L)
      return jjStartNfa_0(9, old0, old1, old2, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(10, active0, active1, 0L, 0L, 0L);
      return 11;
   }
   switch(curChar)
   {
      case 68:
      case 100:
         if ((active1 & 0x800000000000L) != 0L)
            return jjStartNfaWithStates_0(11, 111, 222);
         break;
      case 73:
      case 105:
         return jjMoveStringLiteralDfa12_0(active0, 0x80000000000000L, active1, 0L);
      case 79:
      case 111:
         return jjMoveStringLiteralDfa12_0(active0, 0x200000L, active1, 0L);
      default :
         break;
   }
   return jjStartNfa_0(10, active0, active1, 0L, 0L, 0L);
}
private final int jjMoveStringLiteralDfa12_0(long old0, long active0, long old1, long active1)
{
   if (((active0 &= old0) | (active1 &= old1)) == 0L)
      return jjStartNfa_0(10, old0, old1, 0L, 0L, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(11, active0, 0L, 0L, 0L, 0L);
      return 12;
   }
   switch(curChar)
   {
      case 67:
      case 99:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(12, 55, 222);
         break;
      case 78:
      case 110:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(12, 21, 222);
         break;
      default :
         break;
   }
   return jjStartNfa_0(11, active0, 0L, 0L, 0L, 0L);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0xfffffffffffffffeL, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec2 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
static final long[] jjbitVec3 = {
   0x0L, 0x0L, 0x2800000000L, 0x0L
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 221;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 225:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(157, 174);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  else if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(137, 149);
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(112, 121);
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(100, 104);
                  break;
               case 110:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 73:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 109:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 108:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 57:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 204:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 203:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 221:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 209)
                        kind = 209;
                     jjCheckNAddTwoStates(17, 18);
                  }
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 203)
                        kind = 203;
                     jjCheckNAddTwoStates(88, 89);
                  }
                  break;
               case 222:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 0:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 202)
                        kind = 202;
                     jjCheckNAddStates(0, 8);
                  }
                  else if (curChar == 46)
                     jjCheckNAddTwoStates(88, 17);
                  else if (curChar == 35)
                     jjCheckNAdd(44);
                  else if (curChar == 36)
                     jjAddStates(9, 10);
                  else if (curChar == 34)
                     jjCheckNAddStates(11, 13);
                  else if (curChar == 39)
                     jjCheckNAddStates(14, 16);
                  if (curChar == 48)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 72:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 99:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 106:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 59:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 224:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(46, 55);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 105:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 56:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 223:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(129, 135);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 107:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 58:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 45:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  else if (curChar == 58)
                  {
                     if (kind > 214)
                        kind = 214;
                  }
                  if ((0x3ff001800000000L & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  break;
               case 1:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddStates(14, 16);
                  break;
               case 2:
                  if (curChar == 39)
                     jjCheckNAddStates(17, 19);
                  break;
               case 3:
                  if (curChar == 39)
                     jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  if ((0xffffff7fffffffffL & l) != 0L)
                     jjCheckNAddStates(17, 19);
                  break;
               case 5:
                  if (curChar == 39 && kind > 205)
                     kind = 205;
                  break;
               case 6:
                  if (curChar == 34)
                     jjCheckNAddStates(11, 13);
                  break;
               case 7:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddStates(11, 13);
                  break;
               case 8:
                  if (curChar == 34)
                     jjCheckNAddStates(20, 22);
                  break;
               case 9:
                  if (curChar == 34)
                     jjstateSet[jjnewStateCnt++] = 8;
                  break;
               case 10:
                  if ((0xfffffffbffffffffL & l) != 0L)
                     jjCheckNAddStates(20, 22);
                  break;
               case 11:
                  if (curChar == 34 && kind > 206)
                     kind = 206;
                  break;
               case 12:
                  if (curChar == 48)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 14:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 207)
                     kind = 207;
                  jjstateSet[jjnewStateCnt++] = 14;
                  break;
               case 15:
                  if (curChar == 36)
                     jjAddStates(9, 10);
                  break;
               case 16:
                  if (curChar == 46)
                     jjCheckNAdd(17);
                  break;
               case 17:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAddTwoStates(17, 18);
                  break;
               case 19:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(20);
                  break;
               case 20:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAdd(20);
                  break;
               case 21:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAddStates(23, 26);
                  break;
               case 22:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(22, 23);
                  break;
               case 23:
                  if (curChar != 46)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAddTwoStates(24, 25);
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAddTwoStates(24, 25);
                  break;
               case 26:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(27);
                  break;
               case 27:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAdd(27);
                  break;
               case 28:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAddTwoStates(28, 29);
                  break;
               case 30:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(31);
                  break;
               case 31:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 209)
                     kind = 209;
                  jjCheckNAdd(31);
                  break;
               case 34:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjAddStates(27, 28);
                  break;
               case 37:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 213)
                     kind = 213;
                  jjCheckNAddTwoStates(37, 38);
                  break;
               case 38:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 213)
                     kind = 213;
                  jjCheckNAdd(38);
                  break;
               case 40:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 215)
                     kind = 215;
                  jjCheckNAddTwoStates(40, 41);
                  break;
               case 41:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 215)
                     kind = 215;
                  jjCheckNAdd(41);
                  break;
               case 43:
                  if (curChar == 35)
                     jjCheckNAdd(44);
                  break;
               case 44:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 216)
                     kind = 216;
                  jjCheckNAdd(44);
                  break;
               case 46:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(46, 55);
                  break;
               case 62:
                  if ((0x100002600L & l) != 0L)
                     jjAddStates(29, 30);
                  break;
               case 75:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 202)
                     kind = 202;
                  jjCheckNAddStates(0, 8);
                  break;
               case 76:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 202)
                     kind = 202;
                  jjCheckNAdd(76);
                  break;
               case 77:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(77, 78);
                  break;
               case 78:
                  if (curChar != 46)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAddTwoStates(79, 80);
                  break;
               case 79:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAddTwoStates(79, 80);
                  break;
               case 81:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(82);
                  break;
               case 82:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAdd(82);
                  break;
               case 83:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAddTwoStates(83, 84);
                  break;
               case 85:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(86);
                  break;
               case 86:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAdd(86);
                  break;
               case 87:
                  if (curChar == 46)
                     jjCheckNAddTwoStates(88, 17);
                  break;
               case 88:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAddTwoStates(88, 89);
                  break;
               case 90:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAdd(91);
                  break;
               case 91:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 203)
                     kind = 203;
                  jjCheckNAdd(91);
                  break;
               case 94:
                  if ((0x3ff001800000000L & l) == 0L)
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAdd(94);
                  break;
               case 96:
                  if ((0x3ff001800000000L & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 97:
                  if (curChar == 58 && kind > 214)
                     kind = 214;
                  break;
               case 100:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(100, 104);
                  break;
               case 112:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(112, 121);
                  break;
               case 129:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(129, 135);
                  break;
               case 137:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(137, 149);
                  break;
               case 139:
                  if ((0x100002600L & l) != 0L)
                     jjAddStates(31, 32);
                  break;
               case 157:
                  if ((0x100002600L & l) != 0L)
                     jjCheckNAddTwoStates(157, 174);
                  break;
               case 159:
                  if ((0x100002600L & l) != 0L)
                     jjAddStates(33, 34);
                  break;
               case 182:
                  if ((0x100002600L & l) != 0L)
                     jjAddStates(35, 36);
                  break;
               case 195:
                  if ((0x100002600L & l) != 0L)
                     jjAddStates(37, 38);
                  break;
               case 206:
                  if ((0x100002600L & l) != 0L)
                     jjAddStates(39, 40);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 225:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  break;
               case 110:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 191;
                  else if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 179;
                  else if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 129;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 154;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 126;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 109;
                  break;
               case 73:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 72;
                  break;
               case 109:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 178;
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 153;
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 125;
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 108;
                  break;
               case 108:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 177;
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 152;
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 124;
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 107;
                  break;
               case 57:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x400000004L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 56;
                  break;
               case 204:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 219;
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 203;
                  break;
               case 203:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 218;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 194;
                  break;
               case 222:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  break;
               case 0:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddStates(44, 48);
                  }
                  else if (curChar == 64)
                     jjstateSet[jjnewStateCnt++] = 39;
                  else if (curChar == 91)
                     jjCheckNAdd(33);
                  if ((0x800000008L & l) != 0L)
                     jjAddStates(49, 50);
                  else if ((0x400000004000L & l) != 0L)
                     jjAddStates(51, 56);
                  else if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 73;
                  else if ((0x1000000010L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 59;
                  else if (curChar == 64)
                     jjCheckNAdd(37);
                  break;
               case 72:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x200000002000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 61;
                  break;
               case 99:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 157;
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 137;
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 112;
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 100;
                  break;
               case 106:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 175;
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 150;
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 122;
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 105;
                  break;
               case 59:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 58;
                  break;
               case 224:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  break;
               case 105:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 156;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 136;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 111;
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 99;
                  break;
               case 56:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 45;
                  break;
               case 223:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  break;
               case 107:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 176;
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 151;
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 123;
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 106;
                  break;
               case 58:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x20000000200000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 57;
                  break;
               case 45:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  if ((0x7fffffe87ffffffL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  if ((0x7fffffe87fffffeL & l) != 0L)
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 46;
                  break;
               case 1:
                  jjCheckNAddStates(14, 16);
                  break;
               case 4:
                  jjCheckNAddStates(17, 19);
                  break;
               case 7:
                  jjCheckNAddStates(11, 13);
                  break;
               case 10:
                  jjCheckNAddStates(20, 22);
                  break;
               case 13:
                  if ((0x100000001000000L & l) != 0L)
                     jjCheckNAdd(14);
                  break;
               case 14:
                  if ((0x7e0000007eL & l) == 0L)
                     break;
                  if (kind > 207)
                     kind = 207;
                  jjCheckNAdd(14);
                  break;
               case 18:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(57, 58);
                  break;
               case 25:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(59, 60);
                  break;
               case 29:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(61, 62);
                  break;
               case 32:
                  if (curChar == 91)
                     jjCheckNAdd(33);
                  break;
               case 33:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(63, 65);
                  break;
               case 34:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(34, 35);
                  break;
               case 35:
                  if (curChar == 93 && kind > 211)
                     kind = 211;
                  break;
               case 36:
                  if (curChar == 64)
                     jjCheckNAdd(37);
                  break;
               case 37:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 213)
                     kind = 213;
                  jjCheckNAddTwoStates(37, 38);
                  break;
               case 38:
                  if ((0x7fffffe87ffffffL & l) == 0L)
                     break;
                  if (kind > 213)
                     kind = 213;
                  jjCheckNAdd(38);
                  break;
               case 39:
                  if (curChar == 64)
                     jjCheckNAdd(40);
                  break;
               case 40:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 215)
                     kind = 215;
                  jjCheckNAddTwoStates(40, 41);
                  break;
               case 41:
                  if ((0x7fffffe87ffffffL & l) == 0L)
                     break;
                  if (kind > 215)
                     kind = 215;
                  jjCheckNAdd(41);
                  break;
               case 42:
                  if (curChar == 64)
                     jjstateSet[jjnewStateCnt++] = 39;
                  break;
               case 44:
                  if ((0x7fffffe87ffffffL & l) == 0L)
                     break;
                  if (kind > 216)
                     kind = 216;
                  jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 47:
                  if ((0x400000004000L & l) != 0L && kind > 243)
                     kind = 243;
                  break;
               case 48:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 47;
                  break;
               case 49:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 48;
                  break;
               case 50:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 49;
                  break;
               case 51:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 50;
                  break;
               case 52:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 51;
                  break;
               case 53:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 52;
                  break;
               case 54:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 53;
                  break;
               case 55:
                  if ((0x1000000010000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 54;
                  break;
               case 60:
                  if ((0x1000000010L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 59;
                  break;
               case 61:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 62;
                  break;
               case 63:
                  if ((0x2000000020L & l) != 0L && kind > 250)
                     kind = 250;
                  break;
               case 64:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 63;
                  break;
               case 65:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 64;
                  break;
               case 66:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 65;
                  break;
               case 67:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 66;
                  break;
               case 68:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 67;
                  break;
               case 69:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 68;
                  break;
               case 70:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 69;
                  break;
               case 71:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 70;
                  break;
               case 74:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 73;
                  break;
               case 80:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(66, 67);
                  break;
               case 84:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(68, 69);
                  break;
               case 89:
                  if ((0x2000000020L & l) != 0L)
                     jjAddStates(70, 71);
                  break;
               case 92:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAddStates(44, 48);
                  break;
               case 93:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAddTwoStates(93, 94);
                  break;
               case 94:
                  if ((0x7fffffe87ffffffL & l) == 0L)
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAdd(94);
                  break;
               case 95:
                  if ((0x7fffffe87fffffeL & l) != 0L)
                     jjCheckNAddStates(41, 43);
                  break;
               case 96:
                  if ((0x7fffffe87ffffffL & l) != 0L)
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 98:
                  if ((0x400000004000L & l) != 0L)
                     jjAddStates(51, 56);
                  break;
               case 101:
                  if ((0x4000000040000L & l) != 0L && kind > 244)
                     kind = 244;
                  break;
               case 102:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 101;
                  break;
               case 103:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 102;
                  break;
               case 104:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 103;
                  break;
               case 111:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 112;
                  break;
               case 113:
                  if ((0x4000000040000L & l) != 0L && kind > 245)
                     kind = 245;
                  break;
               case 114:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 113;
                  break;
               case 115:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 114;
                  break;
               case 116:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 115;
                  break;
               case 117:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 116;
                  break;
               case 118:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 117;
                  break;
               case 119:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 118;
                  break;
               case 120:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 119;
                  break;
               case 121:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 120;
                  break;
               case 122:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 111;
                  break;
               case 123:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 122;
                  break;
               case 124:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 123;
                  break;
               case 125:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 124;
                  break;
               case 126:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 125;
                  break;
               case 127:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 126;
                  break;
               case 128:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 129;
                  break;
               case 130:
                  if ((0x100000001000L & l) != 0L && kind > 246)
                     kind = 246;
                  break;
               case 131:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 130;
                  break;
               case 132:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 131;
                  break;
               case 133:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 132;
                  break;
               case 134:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 133;
                  break;
               case 135:
                  if ((0x8000000080000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 134;
                  break;
               case 136:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 137;
                  break;
               case 138:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 139;
                  break;
               case 140:
                  if ((0x8000000080L & l) != 0L && kind > 247)
                     kind = 247;
                  break;
               case 141:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 140;
                  break;
               case 142:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 141;
                  break;
               case 143:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 142;
                  break;
               case 144:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 143;
                  break;
               case 145:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 144;
                  break;
               case 146:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 145;
                  break;
               case 147:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 138;
                  break;
               case 148:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 147;
                  break;
               case 149:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 148;
                  break;
               case 150:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 136;
                  break;
               case 151:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 150;
                  break;
               case 152:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 151;
                  break;
               case 153:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 152;
                  break;
               case 154:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 153;
                  break;
               case 155:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 154;
                  break;
               case 156:
                  if ((0x100000001000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 157;
                  break;
               case 158:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 159;
                  break;
               case 160:
                  if ((0x8000000080L & l) != 0L && kind > 248)
                     kind = 248;
                  break;
               case 161:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 160;
                  break;
               case 162:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 161;
                  break;
               case 163:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 162;
                  break;
               case 164:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 163;
                  break;
               case 165:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 164;
                  break;
               case 166:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 165;
                  break;
               case 167:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 158;
                  break;
               case 168:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 167;
                  break;
               case 169:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 168;
                  break;
               case 170:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 169;
                  break;
               case 171:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 170;
                  break;
               case 172:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 171;
                  break;
               case 173:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 172;
                  break;
               case 174:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 173;
                  break;
               case 175:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 156;
                  break;
               case 176:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 175;
                  break;
               case 177:
                  if ((0x800000008000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 176;
                  break;
               case 178:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 177;
                  break;
               case 179:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 178;
                  break;
               case 180:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 179;
                  break;
               case 181:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 182;
                  break;
               case 183:
                  if ((0x8000000080L & l) != 0L && kind > 249)
                     kind = 249;
                  break;
               case 184:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 183;
                  break;
               case 185:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 184;
                  break;
               case 186:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 185;
                  break;
               case 187:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 186;
                  break;
               case 188:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 187;
                  break;
               case 189:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 188;
                  break;
               case 190:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 181;
                  break;
               case 191:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 190;
                  break;
               case 192:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 191;
                  break;
               case 193:
                  if ((0x800000008L & l) != 0L)
                     jjAddStates(49, 50);
                  break;
               case 194:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 195;
                  break;
               case 196:
                  if ((0x8000000080L & l) != 0L && kind > 251)
                     kind = 251;
                  break;
               case 197:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 196;
                  break;
               case 198:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 197;
                  break;
               case 199:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 198;
                  break;
               case 200:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 199;
                  break;
               case 201:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 200;
                  break;
               case 202:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 201;
                  break;
               case 205:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 206;
                  break;
               case 207:
                  if ((0x8000000080L & l) != 0L && kind > 252)
                     kind = 252;
                  break;
               case 208:
                  if ((0x400000004000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 207;
                  break;
               case 209:
                  if ((0x20000000200L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 208;
                  break;
               case 210:
                  if ((0x200000002000000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 209;
                  break;
               case 211:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 210;
                  break;
               case 212:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 211;
                  break;
               case 213:
                  if ((0x40000000400000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 212;
                  break;
               case 214:
                  if ((0x2000000020L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 205;
                  break;
               case 215:
                  if ((0x10000000100000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 214;
                  break;
               case 216:
                  if ((0x800000008L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 215;
                  break;
               case 217:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 216;
                  break;
               case 218:
                  if ((0x4000000040000L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 217;
                  break;
               case 219:
                  if ((0x200000002L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 218;
                  break;
               case 220:
                  if ((0x10000000100L & l) != 0L)
                     jjstateSet[jjnewStateCnt++] = 219;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 225:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 110:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 73:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 109:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 108:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 57:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 204:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 203:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 222:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 0:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(9, 10);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddStates(44, 48);
                  }
                  break;
               case 72:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 99:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 106:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 59:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 224:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 105:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 56:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 223:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 107:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 58:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 45:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAddTwoStates(93, 94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                  {
                     if (kind > 210)
                        kind = 210;
                     jjCheckNAdd(94);
                  }
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               case 1:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(14, 16);
                  break;
               case 4:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(17, 19);
                  break;
               case 7:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(11, 13);
                  break;
               case 10:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(20, 22);
                  break;
               case 15:
                  if (jjCanMove_1(hiByte, i1, i2, l1, l2))
                     jjAddStates(9, 10);
                  break;
               case 33:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(63, 65);
                  break;
               case 34:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(34, 35);
                  break;
               case 37:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 213)
                     kind = 213;
                  jjCheckNAddTwoStates(37, 38);
                  break;
               case 38:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 213)
                     kind = 213;
                  jjCheckNAdd(38);
                  break;
               case 40:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 215)
                     kind = 215;
                  jjCheckNAddTwoStates(40, 41);
                  break;
               case 41:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 215)
                     kind = 215;
                  jjCheckNAdd(41);
                  break;
               case 44:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 216)
                     kind = 216;
                  jjstateSet[jjnewStateCnt++] = 44;
                  break;
               case 92:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAddStates(44, 48);
                  break;
               case 93:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAddTwoStates(93, 94);
                  break;
               case 94:
                  if (!jjCanMove_0(hiByte, i1, i2, l1, l2))
                     break;
                  if (kind > 210)
                     kind = 210;
                  jjCheckNAdd(94);
                  break;
               case 95:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddStates(41, 43);
                  break;
               case 96:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(96, 97);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 221 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjMoveStringLiteralDfa0_2()
{
   switch(curChar)
   {
      case 42:
         return jjMoveStringLiteralDfa1_2(0x800L);
      case 47:
         return jjMoveStringLiteralDfa1_2(0x400L);
      default :
         return 1;
   }
}
private final int jjMoveStringLiteralDfa1_2(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 42:
         if ((active0 & 0x400L) != 0L)
            return jjStopAtPos(1, 10);
         break;
      case 47:
         if ((active0 & 0x800L) != 0L)
            return jjStopAtPos(1, 11);
         break;
      default :
         return 2;
   }
   return 2;
}
private final int jjMoveStringLiteralDfa0_1()
{
   return jjMoveNfa_1(0, 0);
}
private final int jjMoveNfa_1(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 3;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x2400L & l) != 0L)
                  {
                     if (kind > 7)
                        kind = 7;
                  }
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 1:
                  if (curChar == 10 && kind > 7)
                     kind = 7;
                  break;
               case 2:
                  if (curChar == 13)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 3 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
private final int jjMoveStringLiteralDfa0_3()
{
   switch(curChar)
   {
      case 13:
         return jjMoveStringLiteralDfa1_3(0x80L);
      default :
         return 1;
   }
}
private final int jjMoveStringLiteralDfa1_3(long active3)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active3 & 0x80L) != 0L)
            return jjStopAtPos(1, 199);
         break;
      default :
         return 2;
   }
   return 2;
}
private final int jjStopStringLiteralDfa_4(int pos, long active0, long active1, long active2, long active3)
{
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_4(int pos, long active0, long active1, long active2, long active3)
{
   return jjMoveNfa_4(jjStopStringLiteralDfa_4(pos, active0, active1, active2, active3), pos + 1);
}
private final int jjStartNfaWithStates_4(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_4(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_4()
{
   switch(curChar)
   {
      case 126:
         return jjStopAtPos(0, 200);
      default :
         return jjMoveNfa_4(2, 0);
   }
}
private final int jjMoveNfa_4(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 2;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 2:
               case 0:
                  jjCheckNAddTwoStates(0, 1);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0xbfffffffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(0, 1);
                  else if (curChar == 126)
                  {
                     if (kind > 201)
                        kind = 201;
                  }
                  break;
               case 0:
                  if ((0xbfffffffffffffffL & l) != 0L)
                     jjCheckNAddTwoStates(0, 1);
                  break;
               case 1:
                  if (curChar == 126)
                     kind = 201;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int hiByte = (int)(curChar >> 8);
         int i1 = hiByte >> 6;
         long l1 = 1L << (hiByte & 077);
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 2:
               case 0:
                  if (jjCanMove_0(hiByte, i1, i2, l1, l2))
                     jjCheckNAddTwoStates(0, 1);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 2 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   76, 77, 78, 83, 84, 22, 23, 28, 29, 16, 21, 7, 9, 11, 1, 3, 
   5, 3, 4, 5, 9, 10, 11, 22, 23, 28, 29, 34, 35, 62, 71, 139, 
   146, 159, 166, 182, 189, 195, 202, 206, 213, 95, 96, 97, 93, 94, 95, 96, 
   97, 204, 220, 110, 127, 128, 155, 180, 192, 19, 20, 26, 27, 30, 31, 33, 
   34, 35, 81, 82, 85, 86, 90, 91, 
};
private static final boolean jjCanMove_0(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec2[i2] & l2) != 0L);
      default : 
         if ((jjbitVec0[i1] & l1) != 0L)
            return true;
         return false;
   }
}
private static final boolean jjCanMove_1(int hiByte, int i1, int i2, long l1, long l2)
{
   switch(hiByte)
   {
      case 0:
         return ((jjbitVec3[i2] & l2) != 0L);
      default : 
         return false;
   }
}
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
"\41\45\136\46", null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, null, null, 
null, null, null, null, "\15\12", "\176", null, null, null, null, null, null, null, 
null, null, null, null, null, null, null, null, null, null, null, null, "\174\174", 
"\54", "\73", "\56", null, "\176", "\74", "\74\75", "\76", "\76\75", "\75", "\41\75", 
"\50\53\51", "\50", "\51", "\52", "\57", "\53", "\55", "\77", "\52\75", "\75\52", "\76\76", 
null, null, null, null, null, null, null, null, null, null, "\72", "\41", "\41\76", 
"\41\74", "\74\76", "\174", "\46", "\136", "\45", };
public static final String[] lexStateNames = {
   "DEFAULT", 
   "IN_SINGLE_LINE_COMMENT", 
   "IN_MULTI_LINE_COMMENT", 
   "DESCRIPTION_START_STATE", 
   "DESCRIPTION_STATE", 
};
public static final int[] jjnewLexState = {
   -1, -1, -1, -1, -1, -1, 1, 0, -1, 2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 
   0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
   -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
};
static final long[] jjtoToken = {
   0xffffffffffffe001L, 0xffffffffffffffffL, 0xffffffffffffffffL, 0xfffffffff1eeefffL, 
   0x3fL, 
};
static final long[] jjtoSkip = {
   0x8beL, 0x0L, 0x0L, 0x0L, 
   0x0L, 
};
static final long[] jjtoSpecial = {
   0x880L, 0x0L, 0x0L, 0x0L, 
   0x0L, 
};
static final long[] jjtoMore = {
   0x1740L, 0x0L, 0x0L, 0x0L, 
   0x0L, 
};
protected JavaCharStream input_stream;
private final int[] jjrounds = new int[221];
private final int[] jjstateSet = new int[442];
StringBuffer image;
int jjimageLen;
int lengthOfMatch;
protected char curChar;
public GenericSQLParserTokenManager(JavaCharStream stream)
{
   if (JavaCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public GenericSQLParserTokenManager(JavaCharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(JavaCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 221; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(JavaCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 5 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      matchedToken.specialToken = specialToken;
      return matchedToken;
   }
   image = null;
   jjimageLen = 0;

   for (;;)
   {
     switch(curLexState)
     {
       case 0:
         try { input_stream.backup(0);
            while (curChar <= 32 && (0x100003600L & (1L << curChar)) != 0L)
               curChar = input_stream.BeginToken();
         }
         catch (java.io.IOException e1) { continue EOFLoop; }
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_0();
         break;
       case 1:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_1();
         if (jjmatchedPos == 0 && jjmatchedKind > 8)
         {
            jjmatchedKind = 8;
         }
         break;
       case 2:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_2();
         if (jjmatchedPos == 0 && jjmatchedKind > 12)
         {
            jjmatchedKind = 12;
         }
         break;
       case 3:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_3();
         break;
       case 4:
         jjmatchedKind = 0x7fffffff;
         jjmatchedPos = 0;
         curPos = jjMoveStringLiteralDfa0_4();
         break;
     }
     if (jjmatchedKind != 0x7fffffff)
     {
        if (jjmatchedPos + 1 < curPos)
           input_stream.backup(curPos - jjmatchedPos - 1);
        if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           matchedToken = jjFillToken();
           matchedToken.specialToken = specialToken;
       if (jjnewLexState[jjmatchedKind] != -1)
         curLexState = jjnewLexState[jjmatchedKind];
           return matchedToken;
        }
        else if ((jjtoSkip[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
        {
           if ((jjtoSpecial[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
           {
              matchedToken = jjFillToken();
              if (specialToken == null)
                 specialToken = matchedToken;
              else
              {
                 matchedToken.specialToken = specialToken;
                 specialToken = (specialToken.next = matchedToken);
              }
              SkipLexicalActions(matchedToken);
           }
           else 
              SkipLexicalActions(null);
         if (jjnewLexState[jjmatchedKind] != -1)
           curLexState = jjnewLexState[jjmatchedKind];
           continue EOFLoop;
        }
        MoreLexicalActions();
      if (jjnewLexState[jjmatchedKind] != -1)
        curLexState = jjnewLexState[jjmatchedKind];
        curPos = 0;
        jjmatchedKind = 0x7fffffff;
        try {
           curChar = input_stream.readChar();
           continue;
        }
        catch (java.io.IOException e1) { }
     }
     int error_line = input_stream.getEndLine();
     int error_column = input_stream.getEndColumn();
     String error_after = null;
     boolean EOFSeen = false;
     try { input_stream.readChar(); input_stream.backup(1); }
     catch (java.io.IOException e1) {
        EOFSeen = true;
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
        if (curChar == '\n' || curChar == '\r') {
           error_line++;
           error_column = 0;
        }
        else
           error_column++;
     }
     if (!EOFSeen) {
        input_stream.backup(1);
        error_after = curPos <= 1 ? "" : input_stream.GetImage();
     }
     throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
   }
  }
}

void SkipLexicalActions(Token matchedToken)
{
   switch(jjmatchedKind)
   {
      case 11 :
         if (image == null)
            image = new StringBuffer(new String(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1))));
         else
            image.append(input_stream.GetSuffix(jjimageLen + (lengthOfMatch = jjmatchedPos + 1)));
                commentNestingDepth -= 1;
            SwitchTo( commentNestingDepth==0 ? DEFAULT : IN_MULTI_LINE_COMMENT );
         break;
      default :
         break;
   }
}
void MoreLexicalActions()
{
   jjimageLen += (lengthOfMatch = jjmatchedPos + 1);
   switch(jjmatchedKind)
   {
      case 9 :
         if (image == null)
              image = new StringBuffer(new String(input_stream.GetSuffix(jjimageLen)));
         else
            image.append(input_stream.GetSuffix(jjimageLen));
         jjimageLen = 0;
                         commentNestingDepth = 1 ;
         break;
      case 10 :
         if (image == null)
              image = new StringBuffer(new String(input_stream.GetSuffix(jjimageLen)));
         else
            image.append(input_stream.GetSuffix(jjimageLen));
         jjimageLen = 0;
                                                    commentNestingDepth += 1 ;
         break;
      default : 
         break;
   }
}
}
