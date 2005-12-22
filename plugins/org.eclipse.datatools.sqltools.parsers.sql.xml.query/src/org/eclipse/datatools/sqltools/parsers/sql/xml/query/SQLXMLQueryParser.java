/*******************************************************************************
 * Copyright (c) 2004, 2005 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0
 * which is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.sqltools.parsers.sql.xml.query;
	

import java.util.List;

import org.eclipse.datatools.modelbase.sql.datatypes.DataType;
import org.eclipse.datatools.modelbase.sql.query.ColumnName;
import org.eclipse.datatools.modelbase.sql.query.Grouping;
import org.eclipse.datatools.modelbase.sql.query.GroupingExpression;
import org.eclipse.datatools.modelbase.sql.query.GroupingSetsElement;
import org.eclipse.datatools.modelbase.sql.query.GroupingSetsElementExpression;
import org.eclipse.datatools.modelbase.sql.query.GroupingSpecification;
import org.eclipse.datatools.modelbase.sql.query.OrderBySpecification;
import org.eclipse.datatools.modelbase.sql.query.Predicate;
import org.eclipse.datatools.modelbase.sql.query.QueryExpressionBody;
import org.eclipse.datatools.modelbase.sql.query.QueryExpressionRoot;
import org.eclipse.datatools.modelbase.sql.query.QueryResultSpecification;
import org.eclipse.datatools.modelbase.sql.query.QuerySearchCondition;
import org.eclipse.datatools.modelbase.sql.query.QueryStatement;
import org.eclipse.datatools.modelbase.sql.query.QueryValueExpression;
import org.eclipse.datatools.modelbase.sql.query.SuperGroupElement;
import org.eclipse.datatools.modelbase.sql.query.SuperGroupElementExpression;
import org.eclipse.datatools.modelbase.sql.query.TableCorrelation;
import org.eclipse.datatools.modelbase.sql.query.TableInDatabase;
import org.eclipse.datatools.modelbase.sql.query.TableReference;
import org.eclipse.datatools.modelbase.sql.query.UpdateAssignmentExpression;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseElse;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseSearchContent;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionCaseSimpleContent;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionColumn;
import org.eclipse.datatools.modelbase.sql.query.ValueExpressionSimple;
import org.eclipse.datatools.modelbase.sql.query.ValuesRow;
import org.eclipse.datatools.modelbase.sql.query.WithTableSpecification;
import org.eclipse.datatools.modelbase.sql.query.util.SQLQuerySourceFormat;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLAttributeDeclarationItem;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLAttributesDeclaration;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLNamespaceDeclarationItem;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLNamespacesDeclaration;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLQueryArgumentItem;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLQueryArgumentList;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLQueryExpression;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLTableColumnDefinitionItem;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLTableFunction;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionElementContentList;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionForestContentItem;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionQueryReturning;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionValidateAccordingTo;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionValidateElement;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionValidateElementName;
import org.eclipse.datatools.modelbase.sql.xml.query.XMLValueFunctionValidateElementNamespace;
import org.eclipse.datatools.sqltools.parsers.sql.SQLParserInternalException;
import org.eclipse.datatools.sqltools.parsers.sql.query.AbstractSQLQueryParser;

import com.ibm.lpg.LexStream;

class SQLXMLQueryParser extends  AbstractSQLQueryParser  //SQLParser
{
	SQLXMLQueryParserFactory m_factory;


    /**
     * @param lexStream
     * @param factory
     * @param sourceFormat
     * @param checkStmtOnly
     */
	SQLXMLQueryParser( LexStream lexStream,
	               SQLXMLQueryParserFactory factory,
	               SQLQuerySourceFormat sourceFormat,
	               boolean checkStmtOnly) throws SQLParserInternalException
	{
        super(lexStream, new SQLXMLQueryParserprs(), SQLXMLQueryParserprs.EOFT_SYMBOL, sourceFormat, checkStmtOnly);
		this.m_factory = factory;
	}

	SQLXMLQueryParser(LexStream lexStream, SQLXMLQueryParserFactory factory, SQLQuerySourceFormat sourceFormat)
		 throws SQLParserInternalException
	{
		this(lexStream, factory, sourceFormat, false);
	}

	SQLXMLQueryParser(LexStream lexStream, SQLXMLQueryParserFactory factory)
		 throws SQLParserInternalException
	{
		this(lexStream, factory, SQLQuerySourceFormat.copyDefaultFormat());
	}

	SQLXMLQueryParser(LexStream lexStream, SQLXMLQueryParserFactory factory, boolean checkStmtOnly)
		 throws SQLParserInternalException
	{
		this(lexStream, factory, SQLQuerySourceFormat.copyDefaultFormat(), checkStmtOnly);
	}

	SQLXMLQueryParser(LexStream lexStream)  throws SQLParserInternalException {
		this(lexStream, new SQLXMLQueryParserFactory());
	}

	SQLXMLQueryParser(LexStream lexStream, boolean checkStmtOnly)  throws SQLParserInternalException {
		this(lexStream, new SQLXMLQueryParserFactory(), checkStmtOnly);
	}


	public String[] orderedTerminalSymbols() { return SQLXMLQueryParsersym.orderedTerminalSymbols; }


	protected double getTokenDbl(int p_tok) {
		int tok = p_tok;
		int tokKind = getKind(p_tok);
		if (tokKind == SQLXMLQueryParsersym.TK_MINUS_SIGN) {
			++tok;
			return -1*Double.parseDouble(getTokenName(tok));
		} else if (tokKind == SQLXMLQueryParsersym.TK_PLUS_SIGN) {
			++tok;
		}
		return Double.parseDouble(getTokenName(p_tok));
	}

	protected int getTokenInt(int p_tok) {
		int tok = p_tok;
		int tokKind = getKind(p_tok);
		if (tokKind == SQLXMLQueryParsersym.TK_MINUS_SIGN) {
			++tok;
			return -1*Integer.parseInt(getTokenName(tok));
		} else if (tokKind == SQLXMLQueryParsersym.TK_PLUS_SIGN) {
			++tok;
		}
		return Integer.parseInt(getTokenName(tok));
	}






	public void ruleAction( int ruleNumber)
	{
		switch(ruleNumber)
		{
	
 
			/*
			 *  Rule 1:  <sql_dml_stmt_list> ::= <sql_dml_stmt_xspan>
			 */
			case 1: 
			{
			    setSym1( m_factory.listConcat(null, getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 2:  <sql_dml_stmt_list> ::= <sql_dml_stmt_list> _STMT_TERM <sql_dml_stmt_xspan>
			 */
			case 2: 
			{
			   
				//List stmts = getList(1);
				//QueryStatement stmt = (QueryStatement) stmts.get(stmts.size()-1);
				//extendSpan(stmt,2);
				setSym1( m_factory.listConcat(getList(1), getSym(3)));
			
			}
			break;   
			/*
			 *  Rule 4:  <sql_dml_stmt_xspan> ::= <sql_dml_stmt>
			 */
			case 4: 
			{
			   
	    	if (hasComments()) extendSpanToFollowingToken((QueryStatement) getSym(1), SQLXMLQueryParsersym.TK_STATEMENT_TERMINATOR);
		
			}
			break;   
			/*
			 *  Rule 9:  <all_or_any_cond> ::= <expression> <relop> ANY <subquery>
			 */
			case 9: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createPredicateQuantifiedValueSelect((QueryValueExpression)getSym(1),getInt(2),SQLXMLQueryParserFactory.QUANTIFIER_ANY,(QueryExpressionRoot)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 10:  <all_or_any_cond> ::= <expression> <relop> SOME <subquery>
			 */
			case 10: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createPredicateQuantifiedValueSelect((QueryValueExpression)getSym(1),getInt(2),SQLXMLQueryParserFactory.QUANTIFIER_SOME,(QueryExpressionRoot)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 11:  <all_or_any_cond> ::= <expression> <relop> ALL <subquery>
			 */
			case 11: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createPredicateQuantifiedValueSelect((QueryValueExpression)getSym(1),getInt(2),SQLXMLQueryParserFactory.QUANTIFIER_ALL,(QueryExpressionRoot)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 12:  <all_or_any_cond> ::= _LPAREN <expression_commalist_multiple_elements> _RPAREN _EQ ANY <subquery>
			 */
			case 12: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createPredicateQuantifiedRowSelect(getList(2),SQLXMLQueryParserFactory.QUANTIFIER_ANY,(QueryExpressionRoot)getSym(6))); 
			}
			break;  
 
			/*
			 *  Rule 13:  <all_or_any_cond> ::= _LPAREN <expression_commalist_multiple_elements> _RPAREN _EQ SOME <subquery>
			 */
			case 13: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createPredicateQuantifiedRowSelect(getList(2),SQLXMLQueryParserFactory.QUANTIFIER_SOME,(QueryExpressionRoot)getSym(6))); 
			}
			break;  
 
			/*
			 *  Rule 15:  <boolean_expression> ::= <boolean_expression> OR <boolean_term>
			 */
			case 15: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			   
				setSym1(m_factory.createCombinedCondition((QuerySearchCondition)getSym(1), (QuerySearchCondition)getSym(3), SQLXMLQueryParserFactory.COMBINED_OPERATOR_OR)); 
			}
			break;   
			/*
			 *  Rule 17:  <boolean_term> ::= <boolean_term> AND <boolean_factor>
			 */
			case 17: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedCondition((QuerySearchCondition)getSym(1), (QuerySearchCondition)getSym(3), SQLXMLQueryParserFactory.COMBINED_OPERATOR_AND)); 
			}
			break;  
 
			/*
			 *  Rule 19:  <boolean_factor> ::= <boolean_primary> IS <boolean_values>
			 */
			case 19: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    m_factory.negateCondition((QuerySearchCondition)getSym(1),!getBoolean(3)); 
			}
			break;  
 
			/*
			 *  Rule 20:  <boolean_factor> ::= <boolean_primary> IS NOT <boolean_values>
			 */
			case 20: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    m_factory.negateCondition((QuerySearchCondition)getSym(1),getBoolean(4)); 
			}
			break;  
 
			/*
			 *  Rule 21:  <boolean_values> ::= TRUE
			 */
			case 21: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(new Boolean(true)); 
			}
			break;  
 
			/*
			 *  Rule 22:  <boolean_values> ::= FALSE
			 */
			case 22: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(new Boolean(false)); 
			}
			break;  
 
			/*
			 *  Rule 24:  <boolean_primary> ::= NOT <simplecomp>
			 */
			case 24: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.negatePredicate((Predicate)getSym(2),true)); 
			}
			break;  
 
			/*
			 *  Rule 25:  <boolean_primary> ::= _LPAREN <boolean_expression> _RPAREN
			 */
			case 25: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createNestedCondition((QuerySearchCondition)getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 26:  <boolean_primary> ::= NOT _LPAREN <boolean_expression> _RPAREN
			 */
			case 26: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createNestedConditionNegated((QuerySearchCondition)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 27:  <cast_expression> ::= CAST _LPAREN <cast_operand> AS <cast_target> _RPAREN
			 */
			case 27: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCastExpression((QueryValueExpression)getSym(3), (DataType)getSym(5))); 
			}
			break;  
 
			/*
			 *  Rule 31:  <cast_target> ::= <domain_name>
			 */
			case 31: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createUserDefinedTypeFromDomainName(getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 32:  <case_expression> ::= CASE <case_search_when_list> <opt_case_else> END
			 */
			case 32: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSearchExpression(getList(2), (ValueExpressionCaseElse)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 33:  <case_expression> ::= CASE <expression> <case_simple_when_list> <opt_case_else> END
			 */
			case 33: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSimpleExpression((QueryValueExpression)getSym(2), getList(3), (ValueExpressionCaseElse)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 34:  <case_search_when> ::= WHEN <condition> THEN <expression>
			 */
			case 34: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSearchContent((QuerySearchCondition)getSym(2), (QueryValueExpression)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 35:  <case_search_when_list> ::= <case_search_when>
			 */
			case 35: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSearchList(null,(ValueExpressionCaseSearchContent)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 36:  <case_search_when_list> ::= <case_search_when_list> <case_search_when>
			 */
			case 36: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSearchList(getList(1),(ValueExpressionCaseSearchContent)getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 37:  <case_simple_when> ::= WHEN <expression> THEN <expression>
			 */
			case 37: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSimpleContent((QueryValueExpression)getSym(2), (QueryValueExpression)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 38:  <case_simple_when_list> ::= <case_simple_when>
			 */
			case 38: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSimpleList(null,(ValueExpressionCaseSimpleContent)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 39:  <case_simple_when_list> ::= <case_simple_when_list> <case_simple_when>
			 */
			case 39: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseSimpleList(getList(1),(ValueExpressionCaseSimpleContent)getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 41:  <column_ref> ::= <column>
			 */
			case 41: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnExpression(getString(1),null)); 
			}
			break;  
 
			/*
			 *  Rule 42:  <column_ref> ::= <opt_schema_dot> <table> _DOT <column>
			 */
			case 42: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnExpression(getString(4),getString(2),getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 44:  <constant> ::= _STRING
			 */
			case 44: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression(getTokenName(1))); 
			}
			break;  
 
			/*
			 *  Rule 45:  <constant> ::= G _STRING
			 */
			case 45: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression( "G".concat(getTokenName(2)) ));  //$NON-NLS-1$
			   
			}
			break;   
			/*
			 *  Rule 46:  <constant> ::= N _STRING
			 */
			case 46: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression( "N".concat(getTokenName(2)) ));  //$NON-NLS-1$
			   
			}
			break;   
			/*
			 *  Rule 47:  <constant> ::= X _STRING
			 */
			case 47: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression( "X".concat(getTokenName(2)) ));  //$NON-NLS-1$
			   
			}
			break;   
			/*
			 *  Rule 48:  <constant> ::= _INTNUMBER
			 */
			case 48: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression(getTokenName(1))); 
			}
			break;  
 
			/*
			 *  Rule 49:  <constant> ::= _DECIMALNUMBER
			 */
			case 49: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression(getTokenName(1))); 
			}
			break;  
 
			/*
			 *  Rule 50:  <constant> ::= _REALNUMBER
			 */
			case 50: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression(getTokenName(1))); 
			}
			break;  
 
			/*
			 *  Rule 56:  <datatype_array_type> ::= <datatype> ARRAY
			 */
			case 56: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeArray((DataType)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 57:  <datatype_array_type> ::= <datatype> ARRAY <left_bracket_or_trigraph> <unsigned_integer> <right_bracket_or_trigraph>
			 */
			case 57: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeArray((DataType)getSym(1), getInt(4))); 
			}
			break;  
 
			/*
			 *  Rule 58:  <datatype_multiset_type> ::= <datatype> MULTISET
			 */
			case 58: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeMultiset((DataType)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 65:  <datatype_date> ::= DATE
			 */
			case 65: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeDate()); 
			}
			break;  
 
			/*
			 *  Rule 66:  <datatype_time> ::= TIME
			 */
			case 66: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeTime( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_TIME, 0 )); 
			}
			break;  
 
			/*
			 *  Rule 67:  <datatype_time> ::= TIMESTAMP
			 */
			case 67: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeTime( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_TIMESTAMP, 0 )); 
			}
			break;  
 
			/*
			 *  Rule 72:  <datatype_numerical_approximate> ::= FLOAT
			 */
			case 72: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericApproximate( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_FLOAT, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 73:  <datatype_numerical_approximate> ::= FLOAT _LPAREN _INTNUMBER _RPAREN
			 */
			case 73: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericApproximate( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_FLOAT, Integer.parseInt(getTokenName(3))) ); 
			}
			break;  
 
			/*
			 *  Rule 74:  <datatype_numerical_approximate> ::= REAL
			 */
			case 74: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericApproximate( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_REAL, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 75:  <datatype_numerical_approximate> ::= DOUBLE
			 */
			case 75: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericApproximate( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DOUBLE_PRECISION, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 76:  <datatype_numerical_approximate> ::= DOUBLE PRECISION
			 */
			case 76: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericApproximate( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DOUBLE_PRECISION, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 77:  <datatype_numerical_fixed_precision> ::= NUMERIC
			 */
			case 77: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NUMERIC, 0, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 78:  <datatype_numerical_fixed_precision> ::= DECIMAL
			 */
			case 78: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DECIMAL, 0, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 79:  <datatype_numerical_fixed_precision> ::= DEC
			 */
			case 79: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DECIMAL, 0, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 80:  <datatype_numerical_fixed_precision> ::= NUMERIC _LPAREN _INTNUMBER _RPAREN
			 */
			case 80: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NUMERIC, Integer.parseInt(getTokenName(3)), 0) ); 
			}
			break;  
 
			/*
			 *  Rule 81:  <datatype_numerical_fixed_precision> ::= DECIMAL _LPAREN _INTNUMBER _RPAREN
			 */
			case 81: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DECIMAL, Integer.parseInt(getTokenName(3)), 0) ); 
			}
			break;  
 
			/*
			 *  Rule 82:  <datatype_numerical_fixed_precision> ::= DEC _LPAREN _INTNUMBER _RPAREN
			 */
			case 82: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DECIMAL, Integer.parseInt(getTokenName(3)), 0) ); 
			}
			break;  
 
			/*
			 *  Rule 83:  <datatype_numerical_fixed_precision> ::= NUMERIC _LPAREN _INTNUMBER _COMMA _INTNUMBER _RPAREN
			 */
			case 83: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NUMERIC, Integer.parseInt(getTokenName(3)), Integer.parseInt(getTokenName(5))) ); 
			}
			break;  
 
			/*
			 *  Rule 84:  <datatype_numerical_fixed_precision> ::= DECIMAL _LPAREN _INTNUMBER _COMMA _INTNUMBER _RPAREN
			 */
			case 84: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DECIMAL, Integer.parseInt(getTokenName(3)), Integer.parseInt(getTokenName(5))) ); 
			}
			break;  
 
			/*
			 *  Rule 85:  <datatype_numerical_fixed_precision> ::= DEC _LPAREN _INTNUMBER _COMMA _INTNUMBER _RPAREN
			 */
			case 85: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericFixedPrecision( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_DECIMAL, Integer.parseInt(getTokenName(3)), Integer.parseInt(getTokenName(5))) ); 
			}
			break;  
 
			/*
			 *  Rule 86:  <datatype_numerical_integer> ::= INTEGER
			 */
			case 86: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericInteger( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_INTEGER, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 87:  <datatype_numerical_integer> ::= INT
			 */
			case 87: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericInteger( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_INTEGER, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 88:  <datatype_numerical_integer> ::= SMALLINT
			 */
			case 88: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeNumericInteger( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_SMALLINT, 0) ); 
			}
			break;  
 
			/*
			 *  Rule 89:  <datatype_binary> ::= BLOB _LPAREN _INTNUMBER <datatype_opt_size_unit> _RPAREN
			 */
			case 89: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeBinaryString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_BINARY_LARGE_OBJECT, Integer.parseInt(getTokenName(3)), getString(4) )); 
			}
			break;  
 
			/*
			 *  Rule 90:  <datatype_character> ::= CHARACTER
			 */
			case 90: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER, 0, null) ); 
			}
			break;  
 
			/*
			 *  Rule 91:  <datatype_character> ::= CHAR
			 */
			case 91: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER, 0, null) ); 
			}
			break;  
 
			/*
			 *  Rule 92:  <datatype_character> ::= CHARACTER _LPAREN _INTNUMBER _RPAREN
			 */
			case 92: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER, Integer.parseInt(getTokenName(3)), null )); 
			}
			break;  
 
			/*
			 *  Rule 93:  <datatype_character> ::= CHAR _LPAREN _INTNUMBER _RPAREN
			 */
			case 93: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER, Integer.parseInt(getTokenName(3)), null )); 
			}
			break;  
 
			/*
			 *  Rule 94:  <datatype_character> ::= CHARACTER VARYING _LPAREN _INTNUMBER _RPAREN
			 */
			case 94: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_VARYING, Integer.parseInt(getTokenName(4)), null )); 
			}
			break;  
 
			/*
			 *  Rule 95:  <datatype_character> ::= CHAR VARYING _LPAREN _INTNUMBER _RPAREN
			 */
			case 95: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_VARYING, Integer.parseInt(getTokenName(4)), null )); 
			}
			break;  
 
			/*
			 *  Rule 96:  <datatype_character> ::= VARCHAR _LPAREN _INTNUMBER _RPAREN
			 */
			case 96: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_VARYING, Integer.parseInt(getTokenName(3)), null )); 
			}
			break;  
 
			/*
			 *  Rule 97:  <datatype_character> ::= CLOB
			 */
			case 97: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_LARGE_OBJECT, 0, null )); 
			}
			break;  
 
			/*
			 *  Rule 98:  <datatype_character> ::= CLOB _LPAREN _INTNUMBER <datatype_opt_size_unit> _RPAREN
			 */
			case 98: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_LARGE_OBJECT, Integer.parseInt(getTokenName(3)), getString(4) )); 
			}
			break;  
 
			/*
			 *  Rule 99:  <datatype_character> ::= CHARACTER LARGE OBJECT
			 */
			case 99: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_LARGE_OBJECT, 0, null )); 
			}
			break;  
 
			/*
			 *  Rule 100:  <datatype_character> ::= CHARACTER LARGE OBJECT _LPAREN _INTNUMBER <datatype_opt_size_unit> _RPAREN
			 */
			case 100: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_LARGE_OBJECT, Integer.parseInt(getTokenName(5)), getString(6) )); 
			}
			break;  
 
			/*
			 *  Rule 101:  <datatype_character> ::= CHAR LARGE OBJECT
			 */
			case 101: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_LARGE_OBJECT, 0, null )); 
			}
			break;  
 
			/*
			 *  Rule 102:  <datatype_character> ::= CHAR LARGE OBJECT _LPAREN _INTNUMBER <datatype_opt_size_unit> _RPAREN
			 */
			case 102: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_CHARACTER_LARGE_OBJECT, Integer.parseInt(getTokenName(5)), getString(6) )); 
			}
			break;  
 
			/*
			 *  Rule 103:  <datatype_character_national> ::= GRAPHIC
			 */
			case 103: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NATIONAL_CHARACTER, 0, null )); 
			}
			break;  
 
			/*
			 *  Rule 104:  <datatype_character_national> ::= GRAPHIC _LPAREN _INTNUMBER _RPAREN
			 */
			case 104: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NATIONAL_CHARACTER, Integer.parseInt(getTokenName(3)), null )); 
			}
			break;  
 
			/*
			 *  Rule 105:  <datatype_character_national> ::= VARGRAPHIC _LPAREN _INTNUMBER _RPAREN
			 */
			case 105: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NATIONAL_CHARACTER_VARYING, Integer.parseInt(getTokenName(3)), null )); 
			}
			break;  
 
			/*
			 *  Rule 106:  <datatype_character_national> ::= DBCLOB _LPAREN _INTNUMBER <datatype_opt_size_unit> _RPAREN
			 */
			case 106: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeCharacterString( SQLXMLQueryParserFactory.PRIMITIVE_TYPE_NATIONAL_CHARACTER_LARGE_OBJECT, Integer.parseInt(getTokenName(3)), getString(4) )); 
			}
			break;  
 
			/*
			 *  Rule 107:  <datatype_opt_size_unit> ::= K
			 */
			case 107: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( getTokenName(1) ); 
			}
			break;  
 
			/*
			 *  Rule 108:  <datatype_opt_size_unit> ::= M
			 */
			case 108: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( getTokenName(1) ); 
			}
			break;  
 
			/*
			 *  Rule 109:  <datatype_opt_size_unit> ::= G
			 */
			case 109: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( getTokenName(1) ); 
			}
			break;  
 
			/*
			 *  Rule 110:  <datatype_opt_size_unit> ::= $Empty
			 */
			case 110: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( null ); 
			}
			break;  
 
			/*
			 *  Rule 111:  <datatype_user_defined_distinct> ::= <identifier>
			 */
			case 111: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDistinctUserDefinedType(getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 112:  <delete_stmt> ::= DELETE FROM <target_table> <opt_as_target_table> <opt_where_clause>
			 */
			case 112: 
			{
			    setSym1(m_factory.createDeleteStatement((TableInDatabase)getSym(3), (TableCorrelation)getSym(4), (QuerySearchCondition)getSym(5))); 
			}
			break;  
 
			/*
			 *  Rule 114:  <duration> ::= DAYS
			 */
			case 114: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_DAYS); 
			}
			break;  
 
			/*
			 *  Rule 115:  <duration> ::= HOURS
			 */
			case 115: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_HOURS); 
			}
			break;  
 
			/*
			 *  Rule 116:  <duration> ::= MICROSECONDS
			 */
			case 116: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_MICROSECONDS); 
			}
			break;  
 
			/*
			 *  Rule 117:  <duration> ::= MINUTES
			 */
			case 117: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_MINUTES); 
			}
			break;  
 
			/*
			 *  Rule 118:  <duration> ::= MONTHS
			 */
			case 118: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_MONTHS); 
			}
			break;  
 
			/*
			 *  Rule 119:  <duration> ::= SECONDS
			 */
			case 119: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_SECONDS); 
			}
			break;  
 
			/*
			 *  Rule 120:  <duration> ::= YEARS
			 */
			case 120: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.DURATION_TYPE_YEARS); 
			}
			break;  
 
			/*
			 *  Rule 121:  <exists> ::= EXISTS _LPAREN <query_exp> _RPAREN
			 */
			case 121: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createPredicateExists((QueryExpressionBody) getSym(3)) ); 
			}
			break;  
 
			/*
			 *  Rule 122:  <expression> ::= <expression> _PLUS <expression_term>
			 */
			case 122: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedExpression((QueryValueExpression) getSym(1),SQLXMLQueryParserFactory.COMBINED_OPERATOR_ADD,(QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 123:  <expression> ::= <expression> _MINUS <expression_term>
			 */
			case 123: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedExpression((QueryValueExpression) getSym(1),SQLXMLQueryParserFactory.COMBINED_OPERATOR_SUBTRACT,(QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 125:  <expression_commalist> ::= <expression>
			 */
			case 125: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createExpressionList(null, (QueryValueExpression) getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 126:  <expression_commalist> ::= <expression_commalist> _COMMA <expression>
			 */
			case 126: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createExpressionList(getList(1), (QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 128:  <expression_commalist_multiple_elements> ::= <expression_commalist> _COMMA <expression>
			 */
			case 128: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createExpressionList(getList(1), (QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 129:  <expression_factor> ::= _LPAREN <expression> _RPAREN
			 */
			case 129: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createNestedExpression((QueryValueExpression) getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 130:  <expression_factor> ::= <subquery>
			 */
			case 130: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createScalarSelectExpression((QueryExpressionRoot) getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 138:  <expression_factor> ::= _PLUS <expression_factor>
			 */
			case 138: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.setUnaryOperator((QueryValueExpression)getSym(2),SQLXMLQueryParserFactory.UNARY_OPERATOR_PLUS) ); 
			}
			break;  
 
			/*
			 *  Rule 139:  <expression_factor> ::= _MINUS <expression_factor>
			 */
			case 139: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.setUnaryOperator((QueryValueExpression)getSym(2),SQLXMLQueryParserFactory.UNARY_OPERATOR_MINUS) ); 
			}
			break;  
 
			/*
			 *  Rule 140:  <expression_factor> ::= DEFAULT
			 */
			case 140: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDefaultExpression()); 
			}
			break;  
 
			/*
			 *  Rule 141:  <expression_factor> ::= NULL
			 */
			case 141: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createNullExpression()); 
			}
			break;  
 
			/*
			 *  Rule 142:  <expression_term> ::= <expression_term> _STAR <expression_factor>
			 */
			case 142: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedExpression((QueryValueExpression) getSym(1),SQLXMLQueryParserFactory.COMBINED_OPERATOR_MULTIPLY,(QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 143:  <expression_term> ::= <expression_term> _SLASH <expression_factor>
			 */
			case 143: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedExpression((QueryValueExpression) getSym(1),SQLXMLQueryParserFactory.COMBINED_OPERATOR_DIVIDE,(QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 144:  <expression_term> ::= <expression_term> CONCAT <expression_factor>
			 */
			case 144: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedExpression((QueryValueExpression) getSym(1),SQLXMLQueryParserFactory.COMBINED_OPERATOR_CONCATENATE,(QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 145:  <expression_term> ::= <expression_term> _CONCAT_OPERATOR <expression_factor>
			 */
			case 145: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCombinedExpression((QueryValueExpression) getSym(1),SQLXMLQueryParserFactory.COMBINED_OPERATOR_CONCATENATE,(QueryValueExpression) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 146:  <expression_term> ::= <expression_term> <duration>
			 */
			case 146: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createLabeledDurationExpression((QueryValueExpression) getSym(1), getInt(2))); 
			}
			break;  
 
			/*
			 *  Rule 150:  <func_ref> ::= <alias_name> _DOT <identifier>
			 */
			case 150: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(new String((getString(1).concat(".")).concat(getString(3))));  //$NON-NLS-1$
			   
			}
			break;   
			/*
			 *  Rule 151:  <function> ::= <opt_schema_dot> <identifier> _LPAREN _STAR _RPAREN
			 */
			case 151: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createFunctionExpression(getString(2), null, null, getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 152:  <function> ::= <opt_schema_dot> <identifier> _LPAREN <opt_all_distinct> <opt_expression_commalist> _RPAREN
			 */
			case 152: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createFunctionExpression(getString(2), getString(4), getList(5), getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 154:  <in_cond> ::= <expression> NOT IN _LPAREN <expression_commalist> _RPAREN
			 */
			case 154: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notIn = true;
				setSym1(m_factory.createPredicateInValueList((QueryValueExpression)getSym(1), notIn, getList(5))); 
			}
			break;   
			/*
			 *  Rule 155:  <in_cond> ::= <expression> IN _LPAREN <expression_commalist> _RPAREN
			 */
			case 155: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notIn = false;
				setSym1(m_factory.createPredicateInValueList((QueryValueExpression)getSym(1), notIn, getList(4))); 
			}
			break;   
			/*
			 *  Rule 156:  <in_cond> ::= <expression> NOT IN <subquery>
			 */
			case 156: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notIn = true;
				setSym1(m_factory.createPredicateInValueSelect((QueryValueExpression)getSym(1), notIn, (QueryExpressionRoot)getSym(4))); 
			}
			break;   
			/*
			 *  Rule 157:  <in_cond> ::= <expression> IN <subquery>
			 */
			case 157: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notIn = false;
				setSym1(m_factory.createPredicateInValueSelect((QueryValueExpression)getSym(1), notIn, (QueryExpressionRoot)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 158:  <in_cond> ::= _LPAREN <expression_commalist> _COMMA <expression> _RPAREN NOT IN <subquery>
			 */
			case 158: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notIn = true;
				setSym1(m_factory.createPredicateInValueRowSelect(m_factory.createExpressionList(getList(2),(QueryValueExpression)getSym(4)), notIn, (QueryExpressionRoot)getSym(8))); 
			}
			break;   
			/*
			 *  Rule 159:  <in_cond> ::= _LPAREN <expression_commalist> _COMMA <expression> _RPAREN IN <subquery>
			 */
			case 159: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notIn = false;
				setSym1(m_factory.createPredicateInValueRowSelect(m_factory.createExpressionList(getList(2),(QueryValueExpression)getSym(4)), notIn, (QueryExpressionRoot)getSym(7))); 
			}
			break;   
			/*
			 *  Rule 160:  <insert_row> ::= _LPAREN <expression_commalist_multiple_elements> _RPAREN
			 */
			case 160: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createInsertValuesRow(getList(2))); 
			}
			break;  
 
			/*
			 *  Rule 161:  <insert_row> ::= <expression>
			 */
			case 161: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createInsertValuesRow((QueryValueExpression)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 162:  <insert_row_commalist> ::= <insert_row>
			 */
			case 162: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createInsertRow(null, (ValuesRow) getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 163:  <insert_row_commalist> ::= <insert_row_commalist> _COMMA <insert_row>
			 */
			case 163: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createInsertRow(getList(1), (ValuesRow) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 164:  <insert_stmt> ::= INSERT INTO <target_table> <opt_target_column_list> VALUES <insert_row_commalist>
			 */
			case 164: 
			{
			    setSym1(m_factory.createInsertStatement((TableInDatabase) getSym(3), getList(4), getList(6))); 
			}
			break;  
 
			/*
			 *  Rule 165:  <insert_stmt> ::= INSERT INTO <target_table> <opt_target_column_list> <query_exp_root>
			 */
			case 165: 
			{
			    setSym1(m_factory.createInsertStatement((TableInDatabase)getSym(3), getList(4), (QueryExpressionRoot)getSym(5))); 
			}
			break;  
 
			/*
			 *  Rule 166:  <intervaltest> ::= <expression> NOT BETWEEN <expression> AND <expression>
			 */
			case 166: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notBetween = true;
				setSym1(m_factory.createPredicateBetween((QueryValueExpression)getSym(1), notBetween, (QueryValueExpression)getSym(4), (QueryValueExpression)getSym(6))); 
			}
			break;   
			/*
			 *  Rule 167:  <intervaltest> ::= <expression> BETWEEN <expression> AND <expression>
			 */
			case 167: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notBetween = false;
				setSym1(m_factory.createPredicateBetween((QueryValueExpression)getSym(1), notBetween, (QueryValueExpression)getSym(3), (QueryValueExpression)getSym(5))); 
			}
			break;   
			/*
			 *  Rule 168:  <liketest> ::= <expression> NOT LIKE <expression> <opt_escape>
			 */
			case 168: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notLike = true;
				setSym1(m_factory.createPredicateLike((QueryValueExpression)getSym(1), notLike, (QueryValueExpression)getSym(4), (ValueExpressionSimple)getSym(5))); 
			}
			break;   
			/*
			 *  Rule 169:  <liketest> ::= <expression> LIKE <expression> <opt_escape>
			 */
			case 169: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notLike = false;
				setSym1(m_factory.createPredicateLike((QueryValueExpression)getSym(1), notLike, (QueryValueExpression)getSym(3), (ValueExpressionSimple)getSym(4))); 
			}
			break;   
			/*
			 *  Rule 170:  <nulltest> ::= <expression> IS NOT NULL
			 */
			case 170: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notNull = true;
				setSym1(m_factory.createPredicateNull((QueryValueExpression)getSym(1), notNull)); 
			}
			break;   
			/*
			 *  Rule 171:  <nulltest> ::= <expression> IS NULL
			 */
			case 171: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    boolean notNull = false;
				setSym1(m_factory.createPredicateNull((QueryValueExpression)getSym(1), notNull)); 
			}
			break;   
			/*
			 *  Rule 172:  <null_specification> ::= NULL
			 */
			case 172: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createNullExpression()); 
			}
			break;  
 
			/*
			 *  Rule 173:  <opt_all_distinct> ::= $Empty
			 */
			case 173: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1((String)null); 
			}
			break;  
 
			/*
			 *  Rule 174:  <opt_all_distinct> ::= ALL
			 */
			case 174: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(SQLXMLQueryParserFactory.ALL); 
			}
			break;  
 
			/*
			 *  Rule 175:  <opt_all_distinct> ::= DISTINCT
			 */
			case 175: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(SQLXMLQueryParserFactory.DISTINCT); 
			}
			break;  
 
			/*
			 *  Rule 178:  <opt_as_target_table> ::= <opt_as> <table>
			 */
			case 178: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createTableCorrelation(getString(2))); 
			}
			break;  
 
			/*
			 *  Rule 179:  <opt_as_target_table> ::= $Empty
			 */
			case 179: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 180:  <opt_asc_desc> ::= ASC
			 */
			case 180: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.ORDERING_SPEC_TYPE_ASC); 
			}
			break;  
 
			/*
			 *  Rule 181:  <opt_asc_desc> ::= DESC
			 */
			case 181: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.ORDERING_SPEC_TYPE_DESC); 
			}
			break;  
 
			/*
			 *  Rule 182:  <opt_asc_desc> ::= $Empty
			 */
			case 182: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.ORDERING_SPEC_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 183:  <opt_case_else> ::= ELSE <expression>
			 */
			case 183: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createCaseElse((QueryValueExpression)getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 184:  <opt_case_else> ::= $Empty
			 */
			case 184: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 185:  <opt_default_clause> ::= DEFAULT <default_option>
			 */
			case 185: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 186:  <opt_default_clause> ::= $Empty
			 */
			case 186: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 188:  <default_option> ::= USER
			 */
			case 188: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_USER)); 
			}
			break;  
 
			/*
			 *  Rule 189:  <default_option> ::= CURRENT_USER
			 */
			case 189: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_USER)); 
			}
			break;  
 
			/*
			 *  Rule 190:  <default_option> ::= CURRENT_ROLE
			 */
			case 190: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_ROLE)); 
			}
			break;  
 
			/*
			 *  Rule 191:  <default_option> ::= SESSION_USER
			 */
			case 191: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_SESSION_USER)); 
			}
			break;  
 
			/*
			 *  Rule 192:  <default_option> ::= SYSTEM_USER
			 */
			case 192: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_SYSTEM_USER)); 
			}
			break;  
 
			/*
			 *  Rule 193:  <default_option> ::= CURRENT_PATH
			 */
			case 193: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_PATH)); 
			}
			break;  
 
			/*
			 *  Rule 194:  <opt_escape> ::= ESCAPE _STRING
			 */
			case 194: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleExpression(getTokenName(2))); 
			}
			break;  
 
			/*
			 *  Rule 195:  <opt_escape> ::= $Empty
			 */
			case 195: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 197:  <opt_expression_commalist> ::= $Empty
			 */
			case 197: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 198:  <opt_group_by_clause> ::= GROUP BY <grouping_spec_list>
			 */
			case 198: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getList(3)); 
			}
			break;  
 
			/*
			 *  Rule 199:  <opt_group_by_clause> ::= GROUP BY <super_groups_element_list> WITH CUBE
			 */
			case 199: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createGroupingSpecificationList(null, m_factory.createSuperGroups(getList(3),SQLXMLQueryParserFactory.SUPERGROUP_TYPE_CUBE)) ); 
			}
			break;  
 
			/*
			 *  Rule 200:  <opt_group_by_clause> ::= GROUP BY <super_groups_element_list> WITH ROLLUP
			 */
			case 200: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createGroupingSpecificationList(null, m_factory.createSuperGroups(getList(3),SQLXMLQueryParserFactory.SUPERGROUP_TYPE_ROLLUP)) ); 
			}
			break;  
 
			/*
			 *  Rule 201:  <opt_group_by_clause> ::= $Empty
			 */
			case 201: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1((List)null); 
			}
			break;  
 
			/*
			 *  Rule 202:  <opt_null_order> ::= NULLS FIRST
			 */
			case 202: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.NULL_ORDERING_TYPE_NULLS_FIRST); 
			}
			break;  
 
			/*
			 *  Rule 203:  <opt_null_order> ::= NULLS LAST
			 */
			case 203: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.NULL_ORDERING_TYPE_NULLS_LAST); 
			}
			break;  
 
			/*
			 *  Rule 204:  <opt_null_order> ::= $Empty
			 */
			case 204: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.NULL_ORDERING_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 205:  <grouping_spec_list> ::= <grouping_spec>
			 */
			case 205: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createGroupingSpecificationList(null,(GroupingSpecification) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 206:  <grouping_spec_list> ::= <grouping_spec_list> _COMMA <grouping_spec>
			 */
			case 206: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createGroupingSpecificationList(getList(1),(GroupingSpecification) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 211:  <grouping_exp> ::= <expression>
			 */
			case 211: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createGroupingExpression((QueryValueExpression) getSym(1)) ); 
			}
			break;  
 
			/*
			 *  Rule 212:  <super_groups> ::= CUBE _LPAREN <super_groups_element_list> _RPAREN
			 */
			case 212: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createSuperGroups(getList(3), SQLXMLQueryParserFactory.SUPERGROUP_TYPE_CUBE) ); 
			}
			break;  
 
			/*
			 *  Rule 213:  <super_groups> ::= ROLLUP _LPAREN <super_groups_element_list> _RPAREN
			 */
			case 213: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createSuperGroups(getList(3), SQLXMLQueryParserFactory.SUPERGROUP_TYPE_ROLLUP) ); 
			}
			break;  
 
			/*
			 *  Rule 214:  <super_groups> ::= _LPAREN _RPAREN
			 */
			case 214: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createSuperGroups(null, SQLXMLQueryParserFactory.SUPERGROUP_TYPE_GRANDTOTAL) ); 
			}
			break;  
 
			/*
			 *  Rule 215:  <super_groups_element_list> ::= <super_groups_element>
			 */
			case 215: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSuperGroupsElementList(null,(SuperGroupElement) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 216:  <super_groups_element_list> ::= <super_groups_element_list> _COMMA <super_groups_element>
			 */
			case 216: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSuperGroupsElementList(getList(1),(SuperGroupElement) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 217:  <super_groups_element> ::= _LPAREN <super_groups_element_exp_list> _RPAREN
			 */
			case 217: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createSuperGroupsElementSublist(getList(2)) );  
			}
			break;  
 
			/*
			 *  Rule 219:  <super_groups_element_exp> ::= <grouping_exp>
			 */
			case 219: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createSuperGroupsElementExpression((GroupingExpression) getSym(1)) ); 
			}
			break;  
 
			/*
			 *  Rule 220:  <super_groups_element_exp_list> ::= <super_groups_element_exp>
			 */
			case 220: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSuperGroupsElementExprList(null,(SuperGroupElementExpression) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 221:  <super_groups_element_exp_list> ::= <super_groups_element_exp_list> _COMMA <super_groups_element_exp>
			 */
			case 221: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSuperGroupsElementExprList(getList(1),(SuperGroupElementExpression) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 222:  <grouping_sets> ::= GROUPING SETS _LPAREN <grouping_sets_element_list> _RPAREN
			 */
			case 222: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createGroupingSets(getList(4)) ); 
			}
			break;  
 
			/*
			 *  Rule 223:  <grouping_sets_element_list> ::= <grouping_sets_element>
			 */
			case 223: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createGroupingSetsElementList(null,(GroupingSetsElement) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 224:  <grouping_sets_element_list> ::= <grouping_sets_element_list> _COMMA <grouping_sets_element>
			 */
			case 224: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createGroupingSetsElementList(getList(1),(GroupingSetsElement) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 225:  <grouping_sets_element> ::= _LPAREN <grouping_sets_element_exp_list> _RPAREN
			 */
			case 225: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createGroupingSetsElementSublist(getList(2)) );  
			}
			break;  
 
			/*
			 *  Rule 227:  <grouping_sets_element_exp> ::= <grouping>
			 */
			case 227: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createGroupingSetsElementExpression((Grouping) getSym(1)) ); 
			}
			break;  
 
			/*
			 *  Rule 228:  <grouping_sets_element_exp_list> ::= <grouping_sets_element_exp>
			 */
			case 228: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createGroupingSetsElementExprList(null,(GroupingSetsElementExpression) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 229:  <grouping_sets_element_exp_list> ::= <grouping_sets_element_exp_list> _COMMA <grouping_sets_element_exp>
			 */
			case 229: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createGroupingSetsElementExprList(getList(1),(GroupingSetsElementExpression) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 232:  <opt_having_clause> ::= HAVING <condition>
			 */
			case 232: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 233:  <opt_having_clause> ::= $Empty
			 */
			case 233: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 234:  <opt_join_type> ::= INNER
			 */
			case 234: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.JOIN_EXPLICIT_INNER); 
			}
			break;  
 
			/*
			 *  Rule 235:  <opt_join_type> ::= LEFT <opt_join_type_outer>
			 */
			case 235: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.JOIN_LEFT_OUTER); 
			}
			break;  
 
			/*
			 *  Rule 236:  <opt_join_type> ::= RIGHT <opt_join_type_outer>
			 */
			case 236: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.JOIN_RIGHT_OUTER); 
			}
			break;  
 
			/*
			 *  Rule 237:  <opt_join_type> ::= FULL <opt_join_type_outer>
			 */
			case 237: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.JOIN_FULL_OUTER); 
			}
			break;  
 
			/*
			 *  Rule 238:  <opt_join_type> ::= $Empty
			 */
			case 238: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.JOIN_DEFAULT_INNER); 
			}
			break;  
 
			/*
			 *  Rule 241:  <opt_order_by_clause> ::= ORDER BY <ordering_spec_commalist>
			 */
			case 241: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getList(3)); 
			}
			break;  
 
			/*
			 *  Rule 242:  <opt_order_by_clause> ::= $Empty
			 */
			case 242: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1((List)null); 
			}
			break;  
 
			/*
			 *  Rule 244:  <opt_as_alias> ::= $Empty
			 */
			case 244: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 246:  <opt_table_correlation> ::= $Empty
			 */
			case 246: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 247:  <opt_target_column_list> ::= _LPAREN <target_column_list> _RPAREN
			 */
			case 247: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getList(2)); 
			}
			break;  
 
			/*
			 *  Rule 248:  <opt_target_column_list> ::= $Empty
			 */
			case 248: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 249:  <opt_where_clause> ::= WHERE <condition>
			 */
			case 249: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1_keepSpan(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 250:  <opt_where_clause> ::= $Empty
			 */
			case 250: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null);  
			}
			break;  
 
			/*
			 *  Rule 251:  <opt_schema_dot> ::= <schema> _DOT
			 */
			case 251: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(1)); 
			}
			break;  
 
			/*
			 *  Rule 252:  <opt_schema_dot> ::= $Empty
			 */
			case 252: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 253:  <ordering_spec> ::= <expression> <opt_asc_desc> <opt_null_order>
			 */
			case 253: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createOrderByExpression((QueryValueExpression)getSym(1), getInt(2), getInt(3))); 
			}
			break;  
 
			/*
			 *  Rule 254:  <ordering_spec_commalist> ::= <ordering_spec>
			 */
			case 254: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createOrderByClause(null,(OrderBySpecification) getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 255:  <ordering_spec_commalist> ::= <ordering_spec_commalist> _COMMA <ordering_spec>
			 */
			case 255: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createOrderByClause(getList(1),(OrderBySpecification) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 256:  <parameter> ::= _HOSTVAR
			 */
			case 256: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createVariableExpression(getTokenName(1))); 
			}
			break;  
 
			/*
			 *  Rule 257:  <parameter> ::= _PARAM_MARKER
			 */
			case 257: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createVariableExpression(null)); 
			}
			break;  
 
			/*
			 *  Rule 258:  <project> ::= <expression> <opt_as_alias>
			 */
			case 258: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createResultColumn((QueryValueExpression) getSym(1), getString(2))); 
			}
			break;  
 
			/*
			 *  Rule 259:  <project> ::= _STAR
			 */
			case 259: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 260:  <project> ::= <table> _DOT _STAR
			 */
			case 260: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createResultTableAllColumns(getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 261:  <project> ::= <schema> _DOT <table> _DOT _STAR
			 */
			case 261: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createResultTableAllColumns(getString(3), getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 262:  <query_combined> ::= <query_exp> <query_combined_operator> <query_term>
			 */
			case 262: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createQueryCombined((QueryExpressionBody) getSym(1),getInt(2),(QueryExpressionBody) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 265:  <query_combined_operator> ::= UNION
			 */
			case 265: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.QUERY_COMBINED_UNION); 
			}
			break;  
 
			/*
			 *  Rule 266:  <query_combined_operator> ::= UNION ALL
			 */
			case 266: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.QUERY_COMBINED_UNION_ALL); 
			}
			break;  
 
			/*
			 *  Rule 267:  <query_combined_operator> ::= INTERSECT
			 */
			case 267: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.QUERY_COMBINED_INTERSECT); 
			}
			break;  
 
			/*
			 *  Rule 268:  <query_combined_operator> ::= INTERSECT ALL
			 */
			case 268: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.QUERY_COMBINED_INTERSECT_ALL); 
			}
			break;  
 
			/*
			 *  Rule 269:  <query_combined_operator> ::= EXCEPT
			 */
			case 269: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.QUERY_COMBINED_EXCEPT); 
			}
			break;  
 
			/*
			 *  Rule 270:  <query_combined_operator> ::= EXCEPT ALL
			 */
			case 270: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.QUERY_COMBINED_EXCEPT_ALL); 
			}
			break;  
 
			/*
			 *  Rule 271:  <query_exp_root> ::= <with_clause> <query_exp>
			 */
			case 271: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( m_factory.createQueryExpressionRoot((QueryExpressionBody)getSym(2), getList(1)) ); 
			}
			break;  
 
			/*
			 *  Rule 272:  <query_stmt> ::= <query_exp_root> <opt_order_by_clause>
			 */
			case 272: 
			{
			    setSym1(m_factory.createSelectStatement((QueryExpressionRoot)getSym(1), getList(2))); 
			}
			break;  
 
			/*
			 *  Rule 273:  <query_select> ::= SELECT <opt_all_distinct> <selection> FROM <table_ref_commalist> <opt_where_clause> <opt_group_by_clause> <opt_having_clause>
			 */
			case 273: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createQuerySelect(getString(2),getList(3),getList(5),(QuerySearchCondition)getSym(6),getList(7),(QuerySearchCondition)getSym(8))); 
			}
			break;  
 
			/*
			 *  Rule 276:  <query_term> ::= _LPAREN <query_exp> _RPAREN
			 */
			case 276: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1( getSym(2) );  
			}
			break;  
 
			/*
			 *  Rule 279:  <query_values> ::= VALUES <values_row_commalist>
			 */
			case 279: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createQueryValues(getList(2))); 
			}
			break;  
 
			/*
			 *  Rule 280:  <values_row> ::= _LPAREN <expression_commalist> _RPAREN
			 */
			case 280: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createValuesRow(getList(2))); 
			}
			break;  
 
			/*
			 *  Rule 281:  <values_row> ::= <expression>
			 */
			case 281: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createValuesRow((QueryValueExpression)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 282:  <values_row_commalist> ::= <values_row>
			 */
			case 282: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createValuesRowList(null, (ValuesRow) getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 283:  <values_row_commalist> ::= <values_row_commalist> _COMMA <values_row>
			 */
			case 283: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createValuesRowList(getList(1), (ValuesRow) getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 284:  <relop> ::= _EQ
			 */
			case 284: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.COMPARISON_OPERATOR_EQ); 
			}
			break;  
 
			/*
			 *  Rule 285:  <relop> ::= _LT
			 */
			case 285: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.COMPARISON_OPERATOR_LT); 
			}
			break;  
 
			/*
			 *  Rule 286:  <relop> ::= _LE
			 */
			case 286: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.COMPARISON_OPERATOR_LE); 
			}
			break;  
 
			/*
			 *  Rule 287:  <relop> ::= _NE
			 */
			case 287: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.COMPARISON_OPERATOR_NE); 
			}
			break;  
 
			/*
			 *  Rule 288:  <relop> ::= _GT
			 */
			case 288: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.COMPARISON_OPERATOR_GT); 
			}
			break;  
 
			/*
			 *  Rule 289:  <relop> ::= _GE
			 */
			case 289: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.COMPARISON_OPERATOR_GE); 
			}
			break;  
 
			/*
			 *  Rule 290:  <scalcomp> ::= <expression> <relop> <expression>
			 */
			case 290: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createPredicateBasic((QueryValueExpression)getSym(1),getInt(2),(QueryValueExpression)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 291:  <schema> ::= <identifier>
			 */
			case 291: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(1)); 
			}
			break;  
 
			/*
			 *  Rule 292:  <schema_qualified_name> ::= <identifier>
			 */
			case 292: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(1)); 
			}
			break;  
 
			/*
			 *  Rule 293:  <schema_qualified_name> ::= <schema> _DOT <identifier>
			 */
			case 293: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(1)+"."+getString(3)); 
			}
			break;  
 
			/*
			 *  Rule 294:  <selection> ::= <project>
			 */
			case 294: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSelectClause(null,(QueryResultSpecification)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 295:  <selection> ::= <selection> _COMMA <project>
			 */
			case 295: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSelectClause(getList(1),(QueryResultSpecification)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 303:  <special_register> ::= CURRENT_DATE
			 */
			case 303: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_DATE)); 
			}
			break;  
 
			/*
			 *  Rule 304:  <special_register> ::= CURRENT_TIME
			 */
			case 304: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_TIME)); 
			}
			break;  
 
			/*
			 *  Rule 305:  <special_register> ::= CURRENT_TIMESTAMP
			 */
			case 305: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_TIMESTAMP)); 
			}
			break;  
 
			/*
			 *  Rule 306:  <special_register> ::= CURRENT_TIMESTAMP _LPAREN <timestamp precision> _RPAREN
			 */
			case 306: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_TIMESTAMP)); 
			}
			break;  
 
			/*
			 *  Rule 307:  <special_register> ::= LOCALTIME
			 */
			case 307: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_LOCALTIME)); 
			}
			break;  
 
			/*
			 *  Rule 308:  <special_register> ::= LOCALTIME _LPAREN <time precision> _RPAREN
			 */
			case 308: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_LOCALTIME)); 
			}
			break;  
 
			/*
			 *  Rule 309:  <special_register> ::= LOCALTIMESTAMP
			 */
			case 309: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_LOCALTIMESTAMP)); 
			}
			break;  
 
			/*
			 *  Rule 310:  <special_register> ::= LOCALTIMESTAMP _LPAREN <timestamp precision> _RPAREN
			 */
			case 310: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_LOCALTIMESTAMP)); 
			}
			break;  
 
			/*
			 *  Rule 311:  <special_register> ::= CURRENT_DEFAULT_TRANSFORM_GROUP
			 */
			case 311: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_DEFAULT_TRANSFORM_GROUP)); 
			}
			break;  
 
			/*
			 *  Rule 312:  <special_register> ::= CURRENT_PATH
			 */
			case 312: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_PATH)); 
			}
			break;  
 
			/*
			 *  Rule 313:  <special_register> ::= CURRENT_ROLE
			 */
			case 313: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_ROLE)); 
			}
			break;  
 
			/*
			 *  Rule 314:  <special_register> ::= CURRENT_TRANSFORM_GROUP_FOR_TYPE <path-resolved user-defined type name>
			 */
			case 314: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_TRANSFORM_GROUP_FOR_TYPE)); 
			}
			break;  
 
			/*
			 *  Rule 315:  <special_register> ::= CURRENT_USER
			 */
			case 315: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_CURRENT_USER)); 
			}
			break;  
 
			/*
			 *  Rule 316:  <special_register> ::= SESSION_USER
			 */
			case 316: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_SESSION_USER)); 
			}
			break;  
 
			/*
			 *  Rule 317:  <special_register> ::= SYSTEM_USER
			 */
			case 317: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_SYSTEM_USER)); 
			}
			break;  
 
			/*
			 *  Rule 318:  <special_register> ::= USER
			 */
			case 318: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_USER)); 
			}
			break;  
 
			/*
			 *  Rule 319:  <special_register> ::= VALUE
			 */
			case 319: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSpecialRegisterExpression(SQLXMLQueryParserFactory.SPECIAL_REGISTER_VALUE)); 
			}
			break;  
 
			/*
			 *  Rule 320:  <time precision> ::= UNSIGNED_INTEGER
			 */
			case 320: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 321:  <timestamp precision> ::= UNSIGNED_INTEGER
			 */
			case 321: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 322:  <path-resolved user-defined type name> ::= <opt_schema_dot> <identifier>
			 */
			case 322: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			   
            setSym1(getString(1).concat(".").concat(getString(2))); //$NON-NLS-1$
           
			}
			break;   
			/*
			 *  Rule 323:  <subquery> ::= _LPAREN <query_exp_root> _RPAREN
			 */
			case 323: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 324:  <table> ::= <identifier>
			 */
			case 324: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(1)); 
			}
			break;  
 
			/*
			 *  Rule 326:  <as_alias> ::= <opt_as> <alias_name>
			 */
			case 326: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(2)); 
			}
			break;  
 
			/*
			 *  Rule 327:  <table_correlation> ::= <as_alias>
			 */
			case 327: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createTableCorrelation(getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 328:  <table_join> ::= <table_ref> <opt_join_type> JOIN <table_ref> ON <condition>
			 */
			case 328: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createJoinedTable((TableReference)getSym(1), getInt(2), (TableReference)getSym(4), (QuerySearchCondition)getSym(6))); 
			}
			break;  
 
			/*
			 *  Rule 329:  <table_ref> ::= <schema> _DOT <table> <opt_table_correlation>
			 */
			case 329: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createReferenceTable(getString(1), getString(3), (TableCorrelation)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 330:  <table_ref> ::= <table> <opt_table_correlation>
			 */
			case 330: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createReferenceTable(null, getString(1), (TableCorrelation)getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 333:  <table_ref> ::= _LPAREN <table_ref> _RPAREN
			 */
			case 333: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createNestedTable((TableReference)getSym(2))); 
			}
			break;  
 
			/*
			 *  Rule 334:  <table_query> ::= _LPAREN <query_exp> _RPAREN <table_correlation>
			 */
			case 334: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createTableExpressionQuery((QueryExpressionBody)getSym(2), (TableCorrelation)getSym(4))); 
			}
			break;  
 
			/*
			 *  Rule 335:  <table_query> ::= TABLE _LPAREN <query_exp> _RPAREN <table_correlation>
			 */
			case 335: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createTableExpressionQuery((QueryExpressionBody)getSym(3), (TableCorrelation)getSym(5))); 
			}
			break;  
 
			/*
			 *  Rule 336:  <table_ref_commalist> ::= <table_ref>
			 */
			case 336: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createFromClause((List)null,(TableReference)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 337:  <table_ref_commalist> ::= <table_ref_commalist> _COMMA <table_ref>
			 */
			case 337: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createFromClause(getList(1),(TableReference)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 338:  <target_column_list> ::= <column_ref>
			 */
			case 338: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnList(null,(ValueExpressionColumn) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 339:  <target_column_list> ::= <target_column_list> _COMMA <column_ref>
			 */
			case 339: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnList(getList(1),(ValueExpressionColumn) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 340:  <target_table> ::= <table>
			 */
			case 340: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleTable(null, getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 341:  <target_table> ::= <schema> _DOT <table>
			 */
			case 341: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createSimpleTable(getString(1), getString(3))); 
			}
			break;  
 
			/*
			 *  Rule 343:  <update_assignment_expression> ::= <column_ref> _EQ <expression>
			 */
			case 343: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createUpdateAssignmentExpression((ValueExpressionColumn)getSym(1),(QueryValueExpression)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 344:  <update_assignment_expression> ::= _LPAREN <target_column_list> _RPAREN _EQ _LPAREN <query_exp> _RPAREN
			 */
			case 344: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createUpdateAssignmentExpression(getList(2),(QueryExpressionBody)getSym(6))); 
			}
			break;  
 
			/*
			 *  Rule 345:  <update_assignment_expression> ::= _LPAREN <target_column_list> _RPAREN _EQ _LPAREN <expression_commalist> _RPAREN
			 */
			case 345: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createUpdateAssignmentExpression(getList(2),getList(6))); 
			}
			break;  
 
			/*
			 *  Rule 346:  <update_assignment_expression_commalist> ::= <update_assignment_expression>
			 */
			case 346: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createUpdateAssignmentClause(null,(UpdateAssignmentExpression)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 347:  <update_assignment_expression_commalist> ::= <update_assignment_expression_commalist> _COMMA <update_assignment_expression>
			 */
			case 347: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createUpdateAssignmentClause(getList(1),(UpdateAssignmentExpression)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 348:  <update_stmt> ::= UPDATE <target_table> <opt_as_target_table> SET <update_assignment_clause> <opt_where_clause>
			 */
			case 348: 
			{
			    setSym1(m_factory.createUpdateStatement((TableInDatabase)getSym(2), (TableCorrelation)getSym(3), getList(5), (QuerySearchCondition)getSym(6))); 
			}
			break;  
 
			/*
			 *  Rule 349:  <with_clause> ::= WITH <with_table_spec_list>
			 */
			case 349: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getList(2)); 
			}
			break;  
 
			/*
			 *  Rule 350:  <with_clause> ::= $Empty
			 */
			case 350: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 351:  <with_table_spec_list> ::= <with_table_spec>
			 */
			case 351: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createWithTableSpecificationList(null,(WithTableSpecification) getSym(1)));  
			}
			break;  
 
			/*
			 *  Rule 352:  <with_table_spec_list> ::= <with_table_spec_list> _COMMA <with_table_spec>
			 */
			case 352: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createWithTableSpecificationList(getList(1),(WithTableSpecification) getSym(3)));  
			}
			break;  
 
			/*
			 *  Rule 353:  <with_table_spec> ::= <table> <opt_column_name_list> AS _LPAREN <query_exp> _RPAREN
			 */
			case 353: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createWithTableSpecification(getString(1),getList(2),(QueryExpressionBody) getSym(5)));  
			}
			break;  
 
			/*
			 *  Rule 354:  <opt_column_name_list> ::= _LPAREN <column_name_list> _RPAREN
			 */
			case 354: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getList(2)); 
			}
			break;  
 
			/*
			 *  Rule 355:  <opt_column_name_list> ::= $Empty
			 */
			case 355: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 356:  <column_name_list> ::= <column_name>
			 */
			case 356: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnNameList(null,(ColumnName)getSym(1))); 
			}
			break;  
 
			/*
			 *  Rule 357:  <column_name_list> ::= <column_name_list> _COMMA <column_name>
			 */
			case 357: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnNameList(getList(1),(ColumnName)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 358:  <column_name> ::= <identifier>
			 */
			case 358: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createColumnName(getString(1))); 
			}
			break;  
 
			/*
			 *  Rule 359:  <identifier> ::= REGULAR_IDENTIFIER
			 */
			case 359: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 360:  <identifier> ::= DELIMITED_IDENTIFIER
			 */
			case 360: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 363:  <datatype_xml> ::= XML
			 */
			case 363: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createDataTypeXML()); 
			}
			break;  
 
			/*
			 *  Rule 369:  <table_ref> ::= <xml_table> <table_correlation>
			 */
			case 369: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.addTableCorrelationToTableExpression(
                 (XMLTableFunction)getSym(1),(TableCorrelation)getSym(2))); 
			}
			break;   
			/*
			 *  Rule 370:  <xml_cast_specification> ::= XMLCAST <left_paren> <xml_cast_operand> AS <xml_cast_target> <opt_value_or_ref> <right_paren>
			 */
			case 370: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueExpressionCast(
                    (QueryValueExpression)getSym(3),(DataType)getSym(5),getInt(6))); 
			}
			break;   
			/*
			 *  Rule 373:  <content_or_sequence> ::= CONTENT
			 */
			case 373: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_RETURNING_TYPE_CONTENT); 
			}
			break;  
 
			/*
			 *  Rule 374:  <content_or_sequence> ::= SEQUENCE
			 */
			case 374: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_RETURNING_TYPE_SEQUENCE); 
			}
			break;  
 
			/*
			 *  Rule 375:  <document_or_content> ::= DOCUMENT
			 */
			case 375: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE_DOCUMENT); 
			}
			break;  
 
			/*
			 *  Rule 376:  <document_or_content> ::= CONTENT
			 */
			case 376: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE_CONTENT); 
			}
			break;  
 
			/*
			 *  Rule 377:  <document_or_content_or_sequence> ::= DOCUMENT
			 */
			case 377: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE2_DOCUMENT); 
			}
			break;  
 
			/*
			 *  Rule 378:  <document_or_content_or_sequence> ::= CONTENT
			 */
			case 378: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE2_CONTENT); 
			}
			break;  
 
			/*
			 *  Rule 379:  <document_or_content_or_sequence> ::= SEQUENCE
			 */
			case 379: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE2_SEQUENCE); 
			}
			break;  
 
			/*
			 *  Rule 380:  <document_or_content_or_sequence> ::= $Empty
			 */
			case 380: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE2_NONE); 
			}
			break;  
 
			/*
			 *  Rule 381:  <opt_as_QName> ::= AS <xml_QName>
			 */
			case 381: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getString(2)); 
			}
			break;  
 
			/*
			 *  Rule 382:  <opt_as_QName> ::= $Empty
			 */
			case 382: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 384:  <opt_document_or_content> ::= $Empty
			 */
			case 384: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 385:  <opt_string_value_expression> ::= _COMMA <string_value_expression>
			 */
			case 385: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 386:  <opt_string_value_expression> ::= $Empty
			 */
			case 386: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 387:  <opt_xml_declaration_option> ::= INCLUDING XMLDECLARATION
			 */
			case 387: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_DECLARATION_TYPE_INCLUDING); 
			}
			break;  
 
			/*
			 *  Rule 388:  <opt_xml_declaration_option> ::= EXCLUDING XMLDECLARATION
			 */
			case 388: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_DECLARATION_TYPE_EXCLUDING); 
			}
			break;  
 
			/*
			 *  Rule 389:  <opt_xml_declaration_option> ::= $Empty
			 */
			case 389: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_DECLARATION_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 390:  <opt_xml_attributes> ::= _COMMA <xml_attributes>
			 */
			case 390: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 391:  <opt_xml_attributes> ::= $Empty
			 */
			case 391: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 392:  <opt_xml_element_content_list> ::= _COMMA <xml_element_content_list> <opt_xml_content_option>
			 */
			case 392: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFucnctionElementContentList(getList(2),getInt(3)));
        
			}
			break;   
			/*
			 *  Rule 393:  <opt_xml_element_content_list> ::= $Empty
			 */
			case 393: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 394:  <opt_xml_encoding_specification> ::= ENCODING <xml_encoding_specification>
			 */
			case 394: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 395:  <opt_xml_encoding_specification> ::= $Empty
			 */
			case 395: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 396:  <opt_xml_content_option> ::= OPTION <xml_content_option>
			 */
			case 396: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(getInt(2)); 
			}
			break;  
 
			/*
			 *  Rule 397:  <opt_xml_content_option> ::= $Empty
			 */
			case 397: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_OPTION_NONE); 
			}
			break;  
 
			/*
			 *  Rule 398:  <opt_xml_namespace_declaration_commafirst> ::= _COMMA <xml_namespaces_declaration>
			 */
			case 398: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 399:  <opt_xml_namespace_declaration_commafirst> ::= $Empty
			 */
			case 399: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 400:  <opt_xml_namespace_declaration_commalast> ::= <xml_namespaces_declaration> _COMMA
			 */
			case 400: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(1)); 
			}
			break;  
 
			/*
			 *  Rule 401:  <opt_xml_namespace_declaration_commalast> ::= $Empty
			 */
			case 401: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 402:  <opt_xml_query_argument_list> ::= <xml_query_default_passing_mechanism> <xml_query_argument_list>
			 */
			case 402: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryArgumentList(getInt(1),getList(2))); 
			}
			break;  
 
			/*
			 *  Rule 403:  <opt_xml_query_argument_list> ::= $Empty
			 */
			case 403: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 405:  <opt_xml_returning_clause> ::= $Empty
			 */
			case 405: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_RETURNING_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 406:  <opt_xml_returning_clause_opt_mechanism> ::= <xml_returning_clause> <opt_xml_query_returning_mechanism>
			 */
			case 406: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionQueryReturning(getInt(1),getInt(2)));
                
			}
			break;   
			/*
			 *  Rule 407:  <opt_xml_returning_clause_opt_mechanism> ::= $Empty
			 */
			case 407: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 408:  <opt_xml_serialize_version> ::= VERSION CHAR_STRING_LITERAL
			 */
			case 408: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(2));
			}
			break;  
 
			/*
			 *  Rule 409:  <opt_xml_serialize_version> ::= $Empty
			 */
			case 409: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 410:  <opt_xml_table_argument_list> ::= <xml_passing_mechanism> <xml_query_argument_list>
			 */
			case 410: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryArgumentList(getInt(1),
                    getList(2))); 
			}
			break;   
			/*
			 *  Rule 411:  <opt_xml_table_argument_list> ::= $Empty
			 */
			case 411: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 412:  <opt_xml_table_column_pattern> ::= PATH CHAR_STRING_LITERAL
			 */
			case 412: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(2)); 
			}
			break;  
 
			/*
			 *  Rule 413:  <opt_xml_table_column_pattern> ::= $Empty
			 */
			case 413: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 415:  <opt_xml_query_returning_mechanism> ::= $Empty
			 */
			case 415: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_PASSING_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 417:  <opt_xml_valid_according_to_clause> ::= $Empty
			 */
			case 417: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 419:  <opt_xml_valid_element_name_specification> ::= $Empty
			 */
			case 419: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 420:  <opt_xml_valid_schema_location> ::= LOCATION <xml_valid_schema_location_uri>
			 */
			case 420: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 423:  <opt_xml_valid_element_clause> ::= $Empty
			 */
			case 423: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(null); 
			}
			break;  
 
			/*
			 *  Rule 425:  <opt_value_or_ref> ::= $Empty
			 */
			case 425: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_PASSING_TYPE_NONE); 
			}
			break;  
 
			/*
			 *  Rule 427:  <value_or_ref> ::= BY VALUE
			 */
			case 427: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_PASSING_TYPE_VALUE); 
			}
			break;  
 
			/*
			 *  Rule 428:  <value_or_ref> ::= BY REF
			 */
			case 428: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_PASSING_TYPE_REF); 
			}
			break;  
 
			/*
			 *  Rule 429:  <xml_attributes> ::= XMLATTRIBUTES _LPAREN <xml_attribute_list> _RPAREN
			 */
			case 429: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLAttributesDeclaration(getList(3))); 
			}
			break;  
 
			/*
			 *  Rule 430:  <xml_attribute_list> ::= <xml_attribute>
			 */
			case 430: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLAttributeDeclaraionItemList(
                    null,(XMLAttributeDeclarationItem)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 431:  <xml_attribute_list> ::= <xml_attribute_list> _COMMA <xml_attribute>
			 */
			case 431: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLAttributeDeclaraionItemList(
                    getList(1),(XMLAttributeDeclarationItem)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 432:  <xml_attribute> ::= <expression> AS <identifier>
			 */
			case 432: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLAttributeDeclaraionItem((QueryValueExpression)getSym(1),
                getString(3))); 
			}
			break;   
			/*
			 *  Rule 434:  <xml_serialize_function> ::= XMLSERIALIZE _LPAREN <opt_document_or_content> <xml_value_expression> AS <datatype> <opt_xml_encoding_specification> <opt_xml_serialize_version> <opt_xml_declaration_option> _RPAREN
			 */
			case 434: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLSerializeFunction(getTokenName(1),getInt(3),
                    (QueryValueExpression)getSym(4),(DataType)getSym(6),getString(7),getString(8),getInt(9)));
            
			}
			break;   
			/*
			 *  Rule 435:  <xml_encoding_specification> -> CHAR_STRING_LITERAL
			 */
			case 435: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 446:  <xml_agg_function> ::= XMLAGG _LPAREN <xml_value_expression> <opt_order_by_clause> <opt_xml_returning_clause> _RPAREN
			 */
			case 446: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLAggregateFunction(getTokenName(1),
               (QueryValueExpression)getSym(3),getList(4),getInt(5))); 
			}
			break;   
			/*
			 *  Rule 447:  <xml_concat_function> ::= XMLCONCAT _LPAREN <xml_concat_value_expression_list> <opt_xml_returning_clause> _RPAREN
			 */
			case 447: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionConcat(getTokenName(1),getList(3),getInt(4))); 
			}
			break;  
 
			/*
			 *  Rule 448:  <xml_comment_function> ::= XMLCOMMENT _LPAREN <string_value_expression> <opt_xml_returning_clause> _RPAREN
			 */
			case 448: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionComment(getTokenName(1),(QueryValueExpression)getSym(3),
                getInt(4))); 
			}
			break;   
			/*
			 *  Rule 450:  <xml_content_option> ::= ABSENT ON NULL
			 */
			case 450: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_OPTION_ABSENT_ON_NULL); 
			}
			break;  
 
			/*
			 *  Rule 451:  <xml_content_option> ::= EMPTY ON NULL
			 */
			case 451: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_OPTION_EMPTY_ON_NULL); 
			}
			break;  
 
			/*
			 *  Rule 452:  <xml_content_option> ::= NULL ON NULL
			 */
			case 452: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_OPTION_NULL_ON_NULL); 
			}
			break;  
 
			/*
			 *  Rule 453:  <xml_content_option> ::= NIL ON NULL
			 */
			case 453: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_OPTION_NIL_ON_NULL); 
			}
			break;  
 
			/*
			 *  Rule 454:  <xml_content_option> ::= NIL ON NO CONTENT
			 */
			case 454: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_CONTENT_OPTION_NIL_ON_NO_CONTENT); 
			}
			break;  
 
			/*
			 *  Rule 455:  <xml_document_function> ::= XMLDOCUMENT _LPAREN <xml_value_expression> <opt_xml_returning_clause> _RPAREN
			 */
			case 455: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionDocument(getTokenName(1),
                (QueryValueExpression)getSym(3),getInt(4))); 
			}
			break;   
			/*
			 *  Rule 456:  <xml_element_function> ::= XMLELEMENT _LPAREN NAME <xml_QName> <opt_xml_namespace_declaration_commafirst> <opt_xml_attributes> <opt_xml_element_content_list> <opt_xml_returning_clause> _RPAREN
			 */
			case 456: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFucntionElement(getTokenName(1),getString(4),
                (XMLNamespacesDeclaration)getSym(5),(XMLAttributesDeclaration)getSym(6),
                (XMLValueFunctionElementContentList)getSym(7),getInt(8)));
           
			}
			break;   
			/*
			 *  Rule 457:  <xml_exists> ::= XMLEXISTS _LPAREN <xQuery_expression> <opt_xml_query_argument_list> _RPAREN
			 */
			case 457: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLPredicateExists(getTokenName(1),(XMLQueryExpression)getSym(3),
                (XMLQueryArgumentList)getSym(4))); 
			}
			break;   
			/*
			 *  Rule 458:  <xml_element_content_list> ::= <xml_element_content>
			 */
			case 458: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionElementContentItemList(null,
                (QueryValueExpression)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 459:  <xml_element_content_list> ::= <xml_element_content_list> _COMMA <xml_element_content>
			 */
			case 459: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionElementContentItemList(getList(1),
                (QueryValueExpression)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 461:  <xml_namespaces_declaration> ::= XMLNAMESPACES _LPAREN <xml_namespace_list> _RPAREN
			 */
			case 461: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLNamespaceDeclaration(getList(3))); 
			}
			break;  
 
			/*
			 *  Rule 462:  <xml_namespace_list> ::= <xml_namespace>
			 */
			case 462: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLNamespacesDeclarationItemList(null,
                (XMLNamespaceDeclarationItem)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 463:  <xml_namespace_list> ::= <xml_namespace_list> _COMMA <xml_namespace>
			 */
			case 463: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLNamespacesDeclarationItemList(getList(1),
                (XMLNamespaceDeclarationItem)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 464:  <xml_namespace> ::= <xml_namespace_uri> AS <xml_namespace_prefix>
			 */
			case 464: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLNamespaceDeclarationPrefix(getString(1),
                getString(3))); 
			}
			break;   
			/*
			 *  Rule 465:  <xml_namespace> ::= DEFAULT <xml_namespace_uri>
			 */
			case 465: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLNamespaceDeclarationDefault(getString(2),
                false)); 
			}
			break;   
			/*
			 *  Rule 466:  <xml_namespace> ::= NO DEFAULT
			 */
			case 466: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLNamespaceDeclarationDefault(getString(2),
                true)); 
			}
			break;   
			/*
			 *  Rule 467:  <xml_namespace_uri> ::= CHAR_STRING_LITERAL
			 */
			case 467: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 469:  <xml_forest_function> ::= XMLFOREST _LPAREN <opt_xml_namespace_declaration_commalast> <xml_forest_element_list> <opt_xml_content_option> <opt_xml_returning_clause> _RPAREN
			 */
			case 469: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionForest(getTokenName(1),
                (XMLNamespacesDeclaration)getSym(3),getList(4),getInt(5),getInt(6)));
            
			}
			break;   
			/*
			 *  Rule 470:  <xml_forest_element_list> ::= <xml_forest_element>
			 */
			case 470: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionForestContentItemList(
                null,(XMLValueFunctionForestContentItem)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 471:  <xml_forest_element_list> ::= <xml_forest_element_list> _COMMA <xml_forest_element>
			 */
			case 471: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionForestContentItemList(
                getList(1),(XMLValueFunctionForestContentItem)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 472:  <xml_forest_element> ::= <xml_element_content> <opt_as_QName>
			 */
			case 472: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionForestContentItem((QueryValueExpression)getSym(1),
                getString(2))); 
			}
			break;   
			/*
			 *  Rule 473:  <xml_parse_function> ::= XMLPARSE _LPAREN <document_or_content> <string_value_expression> <xml_whitespace_option> _RPAREN
			 */
			case 473: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionParse(getTokenName(1),getInt(3),
                    (QueryValueExpression)getSym(4),getInt(5))); 
			}
			break;   
			/*
			 *  Rule 474:  <xml_passing_mechanism> ::= PASSING <value_or_ref>
			 */
			case 474: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 475:  <xml_pi_function> ::= XMLPI _LPAREN NAME <xml_pi_target> <opt_string_value_expression> <opt_xml_returning_clause> _RPAREN
			 */
			case 475: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionPI(getTokenName(1),getString(4),
            (QueryValueExpression)getSym(5),getInt(6))); 
			}
			break;   
			/*
			 *  Rule 479:  <xml_query_argument_list> ::= <xml_query_argument>
			 */
			case 479: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryArgumentItemList(null,
                (XMLQueryArgumentItem)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 480:  <xml_query_argument_list> ::= <xml_query_argument_list> _COMMA <xml_query_argument>
			 */
			case 480: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryArgumentItemList(getList(1),
                (XMLQueryArgumentItem)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 481:  <xml_query_context_item> ::= <expression> <opt_value_or_ref>
			 */
			case 481: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryArgumentItem((QueryValueExpression)getSym(1),
                null,getInt(2))); 
			}
			break;   
			/*
			 *  Rule 483:  <xml_query_empty_handling_option> ::= NULL ON EMPTY
			 */
			case 483: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_EMPTYHANDLINGTYPE_NULL_ON_EMPTY); 
			}
			break;  
 
			/*
			 *  Rule 484:  <xml_query_empty_handling_option> ::= EMPTY ON EMPTY
			 */
			case 484: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_EMPTYHANDLINGTYPE_EMPTY_ON_EMPTY); 
			}
			break;  
 
			/*
			 *  Rule 485:  <xml_query_function> ::= XMLQUERY _LPAREN <xQuery_expression> <opt_xml_query_argument_list> <opt_xml_returning_clause_opt_mechanism> <xml_query_empty_handling_option> _RPAREN
			 */
			case 485: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionQuery(getTokenName(1),
                (XMLQueryExpression)getSym(3),(XMLQueryArgumentList)getSym(4),
                (XMLValueFunctionQueryReturning)getSym(5),getInt(6))); 
			}
			break;   
			/*
			 *  Rule 486:  <xml_returning_clause> ::= RETURNING <content_or_sequence>
			 */
			case 486: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getSym(2)); 
			}
			break;  
 
			/*
			 *  Rule 487:  <xml_query_variable> ::= <expression> AS <identifier> <opt_value_or_ref>
			 */
			case 487: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryArgumentItem((QueryValueExpression)getSym(1),
                getString(3),getInt(4))); 
			}
			break;   
			/*
			 *  Rule 488:  <xml_table> ::= XMLTABLE _LPAREN <opt_xml_namespace_declaration_commalast> <xml_table_row_pattern> <opt_xml_table_argument_list> COLUMNS <xml_table_column_definition_list> _RPAREN
			 */
			case 488: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLTableFunction(getTokenName(1),
                (XMLNamespacesDeclaration)getSym(3),getString(4),(XMLQueryArgumentList)getSym(5),
                getList(7))); 
			}
			break;   
			/*
			 *  Rule 489:  <xml_table_row_pattern> ::= CHAR_STRING_LITERAL
			 */
			case 489: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 490:  <xml_table_column_definition_list> ::= <xml_table_column_definition>
			 */
			case 490: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLTableColumnDefinitionList(null,
                (XMLTableColumnDefinitionItem)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 491:  <xml_table_column_definition_list> ::= <xml_table_column_definition_list> _COMMA <xml_table_column_definition>
			 */
			case 491: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLTableColumnDefinitionList(getList(1),
                (XMLTableColumnDefinitionItem)getSym(3))); 
			}
			break;   
			/*
			 *  Rule 494:  <xml_table_ordinality_column_definition> ::= <column> FOR ORDINALITY
			 */
			case 494: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLTableColumnDefinitionOrdinality(
                getString(1))); 
			}
			break;   
			/*
			 *  Rule 495:  <xml_table_regular_column_definition> ::= <column> <datatype> <opt_value_or_ref> <opt_default_clause> <opt_xml_table_column_pattern>
			 */
			case 495: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLTableColumnDefinitionRegular(
                getString(1),(DataType)getSym(2),getInt(3),(QueryValueExpression)getSym(4),getString(5))); 
			}
			break;   
			/*
			 *  Rule 496:  <xml_text_function> ::= XMLTEXT _LPAREN <string_value_expression> <opt_xml_returning_clause> _RPAREN
			 */
			case 496: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionText(getTokenName(1),
                        (QueryValueExpression)getSym(3),getInt(4))); 
			}
			break;   
			/*
			 *  Rule 497:  <xml_uri> ::= CHAR_STRING_LITERAL
			 */
			case 497: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 498:  <xml_valid_according_to_clause> ::= ACCORDING TO XMLSCHEMA <xml_valid_according_to_what> <opt_xml_valid_element_clause>
			 */
			case 498: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.setElementContent((XMLValueFunctionValidateAccordingTo)getSym(4),
                (XMLValueFunctionValidateElement)getSym(5))); 
			}
			break;   
			/*
			 *  Rule 499:  <xml_valid_according_to_identifier> ::= ID <identifier>
			 */
			case 499: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateAccordingToIdentifier(
            null, getString(2))); 
			}
			break;   
			/*
			 *  Rule 500:  <xml_valid_according_to_identifier> ::= ID <schema> _DOT <identifier>
			 */
			case 500: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateAccordingToIdentifier(
            getString(2), getString(4))); 
			}
			break;   
			/*
			 *  Rule 503:  <xml_valid_according_to_uri> ::= URI <xml_valid_target_namespace_uri> <opt_xml_valid_schema_location>
			 */
			case 503: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateAccordingToURI(
                false,getString(2),getString(3))); 
			}
			break;   
			/*
			 *  Rule 504:  <xml_valid_according_to_uri> ::= NO NAMESPACE <opt_xml_valid_schema_location>
			 */
			case 504: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateAccordingToURI(
                true,null,getString(3))); 
			}
			break;   
			/*
			 *  Rule 505:  <xml_valid_element_clause> ::= <xml_valid_element_name_specification>
			 */
			case 505: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateElement(null,
                (XMLValueFunctionValidateElementName)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 506:  <xml_valid_element_clause> ::= <xml_valid_element_namespace_specification> <opt_xml_valid_element_name_specification>
			 */
			case 506: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateElement(
                (XMLValueFunctionValidateElementNamespace)getSym(1),(XMLValueFunctionValidateElementName)getSym(2))); 
			}
			break;   
			/*
			 *  Rule 508:  <xml_valid_element_name_specification> ::= ELEMENT <xml_valid_element_name>
			 */
			case 508: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateElementName(getString(2)));
                
			}
			break;   
			/*
			 *  Rule 510:  <xml_valid_element_namespace_specification> ::= NO NAMESPACE
			 */
			case 510: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateElementNamespace(true,null));
                
			}
			break;   
			/*
			 *  Rule 511:  <xml_valid_element_namespace_specification> ::= NAMESPACE <xml_valid_element_namespace_uri>
			 */
			case 511: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidateElementNamespace(false,getString(2)));
                
			}
			break;   
			/*
			 *  Rule 514:  <xml_validate_function> ::= XMLVALIDATE _LPAREN <document_or_content_or_sequence> <xml_value_expression> <opt_xml_valid_according_to_clause> _RPAREN
			 */
			case 514: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionValidate(getTokenName(1),getInt(3),
                  (QueryValueExpression)getSym(4),(XMLValueFunctionValidateAccordingTo)getSym(5)));
			}
			break;   
			/*
			 *  Rule 515:  <xml_concat_value_expression_list> ::= <xml_value_expression>
			 */
			case 515: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionConcatItemList(null,
                (QueryValueExpression)getSym(1))); 
			}
			break;   
			/*
			 *  Rule 516:  <xml_concat_value_expression_list> ::= <xml_concat_value_expression_list> _COMMA <xml_value_expression>
			 */
			case 516: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLValueFunctionConcatItemList(getList(1),(QueryValueExpression)getSym(3))); 
			}
			break;  
 
			/*
			 *  Rule 517:  <xml_NCName> ::= DELIMITED_IDENTIFIER
			 */
			case 517: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(getTokenName(1)); 
			}
			break;  
 
			/*
			 *  Rule 519:  <xQuery_expression> ::= CHAR_STRING_LITERAL
			 */
			case 519: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setSym1(m_factory.createXMLQueryExpression(getTokenName(1))); 
			}
			break;  
 
			/*
			 *  Rule 520:  <xml_whitespace_option> ::= PRESERVE WHITESPACE
			 */
			case 520: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_WHITESPACE_PRESERVE); 
			}
			break;  
 
			/*
			 *  Rule 521:  <xml_whitespace_option> ::= STRIP WHITESPACE
			 */
			case 521: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_WHITESPACE_STRIP); 
			}
			break;  
 
			/*
			 *  Rule 522:  <xml_whitespace_option> ::= $Empty
			 */
			case 522: 
			{
			    if (checkStmtOnly) {
			        setSym1(null);
			        break;
			    }
			    setInt1(SQLXMLQueryParserFactory.XML_WHITESPACE_NONE); 
			}
			break;  

			default:
				break;

		}
		return;
	}

}
