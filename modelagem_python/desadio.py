import textwrap
from abc import ABC, abstractclassmethod, abstractproperty
from datetime import datetime, date

class Transacao(ABC):
    @property
    @abstractproperty
    def valor(self):
        pass

    @abstractclassmethod
    def registrar(self, conta):
        pass

class Saque(Transacao):
    def __init__(self, valor):
        self._valor = valor
    
    @property
    def valor(self):
        return self._valor

    def registrar(self, conta):
        transacao = conta.sacar(self.valor)
        
        if transacao:
            conta.historico.adicionar_transacao(self)

class Deposito(Transacao):
    def __init__(self, valor):
        self._valor = valor
    
    @property
    def valor(self):
        return self._valor

    def registrar(self, conta):
        transacao = conta.depositar(self.valor)
        
        if transacao:
            conta.historico.adicionar_transacao(self)

class Historico():
    def __init__(self):
        self._transacoes = []

    @property
    def transacoes(self):
        return self._transacoes
    
    def adicionar_transacao(self, transacao):
        self._transacoes.append(
            {
                "tipo": transacao.__class__.__name__,
                "valor": transacao.valor,
                "data": datetime.now().strtime
                ("%d-%m-%Y %M:%M:%S"), #formatando a data
            }
        )

class Cliente():
    def __init__(self, endereco : str):
        self.endereco = endereco
        self.contas = []
    
    def realizar_transacao(self, conta, transacao):
        transacao.resgistrar(conta)

    def adicionar_conta(self, conta):
        self.contas.append(conta)
        

class PessoaFisica(Cliente):
    def __init__(self, 
                 cpf:str, 
                 nome : str, 
                 data_nascimento: date,
                 endereco: str):
        Cliente.__init__(endereco)
        self.cpf = cpf
        self.nome = nome
        self.data_nascimento = data_nascimento

class Conta:
    def __init__(self, 
                 saldo : float, 
                 numero:int, 
                 agencia:str, 
                 cliente:Cliente, 
                 historico:Historico):
        self._saldo = saldo
        self._numero = numero
        self._agencia = agencia
        self._cliente = cliente
        self._historico = historico

    @property
    def saldo(self):
        return self._saldo
    
    @property
    def numero(self):
        return self._numero
    
    @property
    def agencia(self):
        return self._agencia
    
    @property
    def cliente(self):
        return self._cliente
    
    @property
    def historico(self):
        return self._historico
    
    def sacar(self, valor):
        saldo = self.saldo
        excedeu_saldo = valor > saldo
        
        if excedeu_saldo:
            print("\n@@@ Operação falhou! Você não tem saldo suficiente. @@@")

        elif valor > 0:
            self._saldo -= valor
            print("\n=== Saque realizado com sucesso! ===")
            return True
        else:
            print("\n@@@ Operação falhou! O valor informado é inválido. @@@")
        
        return False


    def depositar(self, valor):
        if valor > 0:
            self._saldo += valor
            print(f'Valor depositado: {valor}')
            return True
        else:
            print("\n@@@ Operação falhou! O valor informado é inválido. @@@")
        return False
    
    @classmethod
    def nova_conta(cls, cliente, numero):
        return cls(numero, cliente)


class ContaCorrente(Conta):
    def __init__(self, 
                numero, 
                cliente, 
                limite=1000,
                limite_saques=3):
        super().__init__(numero, cliente)
        self.limite = limite
        self.limite_saques = limite_saques
    
    def sacar(self, valor):
        numero_saques = len([transacao 
                             for transacao 
                             in self.historico.transacoes 
                             if transacao["tipo"] == Saque.__name__])
        excedeu_limite = valor > self.limite
        excedeu_saques = numero_saques >= self.limite_saques

        if excedeu_limite:
            print("\n@@@ Operação falhou! O valor do saque excede o limite. @@@")

        elif excedeu_saques:
            print("\n@@@ Operação falhou! Número máximo de saques excedido. @@@")

        else:
            return super().sacar(valor) 

        return False
    
    def __str__(self) -> str:
        return f'''\
            Agência:\t{self.agencia} 
            C/C:\t{self.numero} 
            Titular:\t{self.nome} 
        '''
    
