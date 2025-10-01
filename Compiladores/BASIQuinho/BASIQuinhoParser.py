# Generated from BASIQuinho.g4 by ANTLR 4.13.2
# encoding: utf-8
from antlr4 import *
from io import StringIO
import sys
if sys.version_info[1] > 5:
	from typing import TextIO
else:
	from typing.io import TextIO

def serializedATN():
    return [
        4,1,0,11,2,0,7,0,1,0,5,0,4,8,0,10,0,12,0,7,9,0,1,0,1,0,1,0,1,5,0,
        1,0,0,0,10,0,5,1,0,0,0,2,4,9,0,0,0,3,2,1,0,0,0,4,7,1,0,0,0,5,6,1,
        0,0,0,5,3,1,0,0,0,6,8,1,0,0,0,7,5,1,0,0,0,8,9,5,0,0,1,9,1,1,0,0,
        0,1,5
    ]

class BASIQuinhoParser ( Parser ):

    grammarFileName = "BASIQuinho.g4"

    atn = ATNDeserializer().deserialize(serializedATN())

    decisionsToDFA = [ DFA(ds, i) for i, ds in enumerate(atn.decisionToState) ]

    sharedContextCache = PredictionContextCache()

    literalNames = [  ]

    symbolicNames = [  ]

    RULE_inicio = 0

    ruleNames =  [ "inicio" ]

    EOF = Token.EOF
    def __init__(self, input:TokenStream, output:TextIO = sys.stdout):
        super().__init__(input, output)
        self.checkVersion("4.13.2")
        self._interp = ParserATNSimulator(self, self.atn, self.decisionsToDFA, self.sharedContextCache)
        self._predicates = None




    class InicioContext(ParserRuleContext):
        __slots__ = 'parser'

        def __init__(self, parser, parent:ParserRuleContext=None, invokingState:int=-1):
            super().__init__(parent, invokingState)
            self.parser = parser

        def EOF(self):
            return self.getToken(BASIQuinhoParser.EOF, 0)

        def getRuleIndex(self):
            return BASIQuinhoParser.RULE_inicio

        def enterRule(self, listener:ParseTreeListener):
            if hasattr( listener, "enterInicio" ):
                listener.enterInicio(self)

        def exitRule(self, listener:ParseTreeListener):
            if hasattr( listener, "exitInicio" ):
                listener.exitInicio(self)




    def inicio(self):

        localctx = BASIQuinhoParser.InicioContext(self, self._ctx, self.state)
        self.enterRule(localctx, 0, self.RULE_inicio)
        try:
            self.enterOuterAlt(localctx, 1)
            self.state = 5
            self._errHandler.sync(self)
            _alt = self._interp.adaptivePredict(self._input,0,self._ctx)
            while _alt!=1 and _alt!=ATN.INVALID_ALT_NUMBER:
                if _alt==1+1:
                    self.state = 2
                    self.matchWildcard() 
                self.state = 7
                self._errHandler.sync(self)
                _alt = self._interp.adaptivePredict(self._input,0,self._ctx)

            self.state = 8
            self.match(BASIQuinhoParser.EOF)
        except RecognitionException as re:
            localctx.exception = re
            self._errHandler.reportError(self, re)
            self._errHandler.recover(self, re)
        finally:
            self.exitRule()
        return localctx





