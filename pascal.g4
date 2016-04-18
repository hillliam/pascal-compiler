grammar pascal;

program
    : programHeading ('INTERFACE'| 'interface')?
      block
      DOT
    ;

programHeading
    : (('PROGRAM'| 'program')|('FUNCTION'| 'function')|('PROCEDURE'| 'procedure') ) identifier (LPAREN identifierList RPAREN)? SEMI
    | ('UNIT' | 'unit') identifier SEMI
  ;

identifier
    : IDENT
    ;

block
    : ( labelDeclarationPart
      | constantDefinitionPart
      | typeDefinitionPart
      | variableDeclarationPart
      | procedureAndFunctionDeclarationPart
      | usesUnitsPart
      | ('IMPLEMENTATION' | 'implementation')
      )*
      compoundStatement
    ;

usesUnitsPart
    : ('USES' | 'uses') identifierList SEMI
    ;

labelDeclarationPart
    : ('LABEL'| 'label') label ( COMMA label )* SEMI
    ;

label
    : unsignedInteger
    ;

constantDefinitionPart
    : ('CONST' | 'const') constantDefinition ( SEMI constantDefinition )* SEMI
    ;

constantDefinition
    : identifier EQUAL constant
    ;

constantChr
    : ('CHR'|'chr') LPAREN (unsignedInteger|identifier) RPAREN
    ;

constant
    : unsignedNumber
    | sign unsignedNumber
    | identifier
    | sign identifier
    | string
    | constantChr
    ;

unsignedNumber
    : unsignedInteger
    | unsignedReal
    ;

unsignedInteger
    : NUM_INT
    ;

unsignedReal
    : NUM_REAL
    ;

sign
    : PLUS | MINUS
    ;

string
    : STRING_LITERAL
    ;

typeDefinitionPart
    : ('TYPE'|'type') typeDefinition ( SEMI typeDefinition )* SEMI
    ;

typeDefinition
    : identifier EQUAL
      ( type
      | functionType
      | procedureType
      )
    ;

functionType
    : ('FUNCTION' | 'function') (formalParameterList)? COLON resultType
    ;

procedureType
    : ('PROCEDURE'| 'procedure') (formalParameterList)?
    ;

type
    : simpleType
    | structuredType
    ;

simpleType
    : scalarType
    | subrangeType
    | typeIdentifier
    | stringtype
    ;

scalarType
    : LPAREN identifierList RPAREN
    ;

subrangeType
    : constant DOTDOT constant
    ;

typeIdentifier
    : identifier
    | ('CHAR'|'char')
    | ('BOOLEAN'|'boolean')
    | ('INTEGER'|'integer')
    | ('REAL'|'real')
    | ('STRING'|'string')
    ;

structuredType
    : ('PACKED'| 'packed') unpackedStructuredType
   | unpackedStructuredType
    ;

unpackedStructuredType
    : arrayType
    | recordType
    | setType
    | subrangeType
    ;

stringtype
    : ('STRING'|'string') LPAREN (identifier|unsignedNumber) RPAREN
    | ('STRING'|'string') LBRACK2 (identifier|unsignedNumber) RBRACK2
    ;

arrayType
    : ('ARRAY'|'array') LBRACK typeList RBRACK ('OF'|'of') componentType
    | ('ARRAY'|'array') LBRACK2 typeList RBRACK2 ('OF'|'of') componentType
  ;

typeList
  : indexType ( COMMA indexType )*
  ;

indexType
    : simpleType
    ;

componentType
    : type
    ;

recordType
    : ('RECORD'|'record') fieldList ('END'|'end')
    ;

fieldList
    : ( fixedPart ( SEMI variantPart | SEMI )?
      | variantPart )
    ;

fixedPart
    : recordSection ( SEMI recordSection )*
    ;

recordSection
    : identifierList COLON type
    ;

variantPart
    : ('CASE'|'case') tag ('OF'| 'of') variant ( SEMI variant | SEMI )*
    ;

tag
    : identifier COLON typeIdentifier
    | typeIdentifier
    ;

variant
    : constList COLON LPAREN fieldList RPAREN
    ;

setType
    : ('SET'| 'set') ('OF'|'of') simpleType
    ;

variableDeclarationPart
    : ('VAR'|'var')  variableDeclaration ( SEMI variableDeclaration )* SEMI
    ;

variableDeclaration
    : identifierList (COLON type)?
    ;

procedureAndFunctionDeclarationPart
    : procedureOrFunctionDeclaration SEMI
    ;

procedureOrFunctionDeclaration
    : procedureDeclaration
    | functionDeclaration
    ;

procedureDeclaration
    : ('PROCEDURE'| 'procedure')  identifier (formalParameterList)? SEMI
      ( block | directive )
    ;

functionDeclaration
    : ('FUNCTION'|'function') identifier (formalParameterList)? COLON resultType SEMI
      ( block | directive )
    ;

directive
    : ('FORWARD'|'forward')
    ;


formalParameterList
    : LPAREN formalParameterSection ( SEMI formalParameterSection )* RPAREN
    ;

formalParameterSection
    : parameterGroup
    | ('VAR'| 'var') parameterGroup
    | ('FUNCTION'|'function') parameterGroup
    | ('PROCEDURE'|'procedure') parameterGroup
    ;

parameterGroup
    : identifierList COLON typeIdentifier
    ;

identifierList
    : identifier ( COMMA identifier )*
    ;

constList
    : constant ( COMMA constant )*
    ;

resultType
    : typeIdentifier
    ;

statement
    : label COLON unlabelledStatement
    | unlabelledStatement
    ;

unlabelledStatement
    : simpleStatement
    | structuredStatement
    ;

exitStatement
    : ('EXIT'| 'exit')
    ;


simpleStatement
    : assignmentStatement
    | procedureStatement
    | inputoutputstatment
    | exitStatement
    | gotoStatement
    | emptyStatement
    ;

inputoutputstatment
    : emptyreadkey
    | emptyreadln
    | emptywrite
    | emptywriteln
    | readkeystatment
    | readlnstatment
    | writestatment
    | writelnstatment
    ;
readkey
    : 'READKEY'
    | 'readkey'
    | 'READ'
    | 'read'
    ;
readln
    : 'readln'
    | 'READLN'
    | 'readline'
    | 'READLINE'
    ;
write
    : 'write'
    | 'WRITE'
    ;
writeln
    : 'writeln'
    | 'WRITELN'
    ;
emptyreadkey
    : readkey
    ;
emptyreadln
    : readln
    ;
emptywrite
    : write
    ;
emptywriteln
    : writeln
    ;
readkeystatment
    : readkey ( LPAREN parameterList RPAREN )?
    ;
readlnstatment
    : readln ( LPAREN parameterList RPAREN )?
    ;
writestatment
    : write ( LPAREN parameterList RPAREN )?
    ;
writelnstatment
    : writeln ( LPAREN parameterList RPAREN )?
    ;

assignmentStatement
    : variable ASSIGN expression
    ;

variable
    : ( ('AT'|'at') identifier
      | identifier
      )
      (  LBRACK expression ( COMMA expression)* RBRACK
      | LBRACK2 expression ( COMMA expression)* RBRACK2
      | DOT identifier
      )*
    ;

expression
    : simpleExpression
    ( (EQUAL | NOT_EQUAL | LT | LE | GE | GT | ('IN'|'in')) simpleExpression )*
    ;

simpleExpression
    : term ( (PLUS | MINUS | ('OR'|'or')) term )*
    ;

term
  : signedFactor ( (STAR | SLASH | ('DIV'|'div') | ('MOD'|'mod') | ('AND'|'and')) signedFactor )*
    ;

signedFactor
    : (PLUS|MINUS)? factor
    ;

factor
    : variable
    | LPAREN expression RPAREN
    | functionDesignator
    | unsignedConstant
    | set
    | ('NOT'|'not') factor
    ;

unsignedConstant
    : unsignedNumber
    | constantChr
    | string
    | ('NIL'|'nil')
    ;

functionDesignator
    : identifier LPAREN parameterList RPAREN
    ;

parameterList
    : actualParameter ( COMMA actualParameter )*
    ;

set
    : LBRACK elementList RBRACK
    | LBRACK2 elementList RBRACK2
    ;

elementList
    : element ( COMMA element )*
    |
    ;

element
    : expression ( DOTDOT expression )?
    ;

procedureStatement
    : identifier ( LPAREN parameterList RPAREN )?
    ;

actualParameter
    : expression (COLON unsignedInteger)?
    ;

gotoStatement
    : ('GOTO'| 'goto') label
    ;

emptyStatement
    :
    ;

empty
    : // nothing
    ;

structuredStatement
    : compoundStatement
    | conditionalStatement
    | repetetiveStatement
    | withStatement
    ;

compoundStatement
    : ('BEGIN'|'begin')
    statements
      ('END'|'end')
    ;

statements
    : statement ( SEMI statement )*
    ;

conditionalStatement
    : ifStatement
    | caseStatement
    ;

ifStatement
    : ('IF'|'if') expression ('THEN'|'then') statement
      (
     ('ELSE'|'else') statement
    )?
    ;

caseStatement
    : ('CASE'|'case') expression ('OF'|'of')
        caseListElement ( SEMI caseListElement )* SEMI?
      ( ('ELSE'|'else') statements )?
      ('END'|'end')
    ;

caseListElement
    : constList COLON statement
    ;

repetetiveStatement
    : whileStatement
    | repeatStatement
    | forStatement
    ;

whileStatement
    : ('WHILE'|'while') expression ('DO'|'do') statement
    ;

repeatStatement
    : ('REPEAT'| 'repeat') statements ('UNTIL'| 'until') expression
    ;

forStatement
    : ('FOR'|'for') identifier ASSIGN forList ('DO'|'do') statement
    ;

forList
    : initialValue (('TO'|'to') | ('DOWNTO'|'downto')) finalValue
    ;

initialValue
    : expression
    ;

finalValue
    : expression
    ;

withStatement
    : ('WITH'| 'with') recordVariableList ('DO'|'do') statement
    ;

recordVariableList
    : variable ( COMMA variable )*
    ;

// Whitespace -- ignored
WS  :   [ \t\r\n]+ -> skip ;

COMMENT_1
        :   LPAREN STAR .*? STAR RPAREN -> skip
        ;

COMMENT_2
        :  LCURLY .*? RCURLY -> skip
  ;

IDENT  :  ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
  ;

STRING_LITERAL
  : '\'' ('\'\'' | ~('\''))* '\''
  ;

// a numeric literal.  Form is (from Wirth)
//  digits
//  digits . digits
//  digits . digits exponent
//  digits exponent
//
NUM_INT
  : ('0'..'9')+
  ;

NUM_REAL
  : ([0-9])+ DOT [0-9]+ EXPONENT?
  ;

EXPONENT
  :  ('e') ('+'|'-')? ('0'..'9')+
  ;


PLUS            : '+'   ;
MINUS           : '-'   ;
STAR            : '*'   ;
SLASH           : '/'   ;
ASSIGN          : ':='  ;
COMMA           : ','   ;
SEMI            : ';'   ;
COLON           : ':'   ;
EQUAL           : '='   ;
NOT_EQUAL       : '<>'  ;
LT              : '<'   ;
LE              : '<='  ;
GE              : '>='  ;
GT              : '>'   ;
LPAREN          : '('   ;
RPAREN          : ')'   ;
LBRACK          : '['   ;
LBRACK2         : '(.'  ;
RBRACK          : ']'   ;
RBRACK2         : '.)'  ;
POINTER         : '^'   ;
AT              : '@'   ;
DOT             : '.' ;
DOTDOT          : '..';
LCURLY          : '{' ;
RCURLY          : '}' ;
