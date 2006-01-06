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
package org.eclipse.datatools.sqltools.db.generic.sql;

import org.eclipse.datatools.sqltools.sql.parser.ISQLSyntax;

/**
 * @author Hui Cao
 * 
 */
public class GenericSQLSyntax implements ISQLSyntax{
	
    private static final String[] _unreservedwords =
    {
    }
    ;

    private static final String[] reservedwords =
    {
        "action" ,
            "add" ,
            "all" ,
            "alter" ,
            "and" ,
            "any" ,
            "as" ,
            "asc" ,
            "authorization" ,
            "begin" ,
            "between" ,
            "boolean" ,
            "by" ,
            "cascade" ,
            "cascaded" ,
            "char" ,
            "character" ,
            "check" ,
            "collate" ,
            "column" ,
            "commit" ,
            "constant" ,
            "constraint" ,
            "corresponding" ,
            "create" ,
            "cross" ,
            "cursor" ,
            "date" ,
            "default" ,
            "declare" ,
            "delete" ,
            "deferrable" ,
            "desc" ,
            "distinct" ,
            "drop" ,
            "end" ,
            "escape" ,
            "except" ,
            "exists" ,
            "false" ,
            "foreign" ,
            "from" ,
            "full" ,
            "global" ,
            "group" ,
            "having" ,
            "immediate" ,
            "in" ,
            "index" ,
            "initially" ,
            "inner" ,
            "insert" ,
            "intersect" ,
            "into" ,
            "is" ,
            "join" ,
            "left" ,
            "like" ,
            "key" ,
            "local" ,
            "match" ,
            "natural" ,
            "no" ,
            "not" ,
            "null" ,
            "on" ,
            "option" ,
            "outer" ,
            "or" ,
            "order" ,
            "partial" ,
            "pendant" ,
            "preserve" ,
            "primary" ,
            "procedure" ,
            "record" ,
            "references" ,
            "restrict" ,
            "right" ,
            "rows" ,
            "schema" ,
            "select" ,
            "set" ,
            "some" ,
            "table" ,
            "temporary" ,
            "then" ,
            "time" ,
            "timestamp" ,
            "true" ,
            "type" ,
            "union" ,
            "unique" ,
            "unknown" ,
            "update" ,
            "user" ,
            "using" ,
            "value" ,
            "values" ,
            "varchar" ,
            "varying" ,
            "view" ,
            "where" ,
            "with" ,
            "zone" ,
    }
    ;

    private static final String[] predicates =
    {
        "||",
            ",",
            ";",
            ".",
            "~",
            "<",
            "<=",
            ",",
            ",=",
            "=",
            "!=",
            "(+)",
            "(",
            ")",
            "*",
            "/",
            "+",
            "-",
            "?"
    }
    ;

    private static final String[] types =
    {
        "dec" ,
            "decimal" ,
            "double" ,
            "float" ,
            "int" ,
            "integer" ,
            "numeric" ,
            "real" ,
            "smallint" ,

    }
    ;
    private static final String[] constants =
    {
        "FALSE", "NULL", "TRUE", "false", "true", "null" 
    }
    ;
    private static final String[] functions =
    {
        "avg" ,
            "both" ,
            "convert" ,
            "count" ,
            "for" ,
            "length" ,
            "leading" ,
            "lower" ,
            "lpad" ,
            "ltrim" ,
            "max" ,
            "min" ,
            "replace" ,
            "rtrim" ,
            "substr" ,
            "substring" ,
            "sum" ,
            "trailing" ,
            "translate" ,
            "trim" ,
            "upper" ,
    }
    ;

    private static final String[] _comments      =
    {
        "--"
    }
    ;

    private Object[] allWords =
    {
        reservedwords, _unreservedwords, predicates, types, constants, functions 
    }
    ;

    /**
     * @return Returns the functions.
     */
    public String[] getFunctions()
    {
        return functions;
    }
    /**
     * @return Returns the predicates.
     */
    public String[] getPredicates()
    {
        return predicates;
    }
    /**
     * @return Returns the reservedwords.
     */
    public String[] getReservedwords()
    {
        return reservedwords;
    }

    public String[] getUnreservedwords()
    {
        return _unreservedwords;
    }

    /**
     * @return Returns the types.
     */
    public String[] getTypes()
    {
        return types;
    }
    /**
     * @return Returns the allWords.
     */
    public Object[] getAllWords()
    {
        return allWords;
    }
    /**
     * @return Returns the constants.
     */
    public  String[] getConstants()
    {
        return constants;
    }

    public String[] getSingleLineComments()
    {
        return _comments;
    }

}
