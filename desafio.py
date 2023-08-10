menu = """
    [d] Depositar
    [s] Sacar
    [e] Extrato
    [q] Sair
=> """

saldo = 0
limite = 500
extrato = ""
numero_saques = 0
LIMITE_SAQUES = 3

while True:
    opcao = input(menu)

    if opcao == "d":
        print("Depositar")
        deposito = int(input("Digite o valor de depósito: "))
        if deposito <= 0:
            print("Valor inválido! Tente outro valor")
        else:
            saldo += deposito
            extrato += f"Dep: +R$ {deposito:,.2f} \n"
    elif opcao == "s":
        print("Sacar")
        sacar = int(input("Digite o valor de saque: "))
        if sacar > 500:
            print("Valor inválido! Limite excedido.")
        elif sacar > saldo:
            print("Saldo insuficiente.")
        elif numero_saques >= LIMITE_SAQUES:
            print("Você excedeu o número de saques diários.")
        elif sacar <= 0:
            print("Valor inválido! Tente outro valor")
        else:
            numero_saques += 1
            saldo -= sacar
            extrato += f"Saq: -R$ {sacar:,.2f} \n"
    elif opcao == "e":
        print("Extrato da Conta: \n")
        print(extrato)
        print("==========================================")
        print(f"Saldo: R$ {saldo:,.2f}")
    elif opcao == "q":
        break
    else:
        print("Operação inválida, favor selecione novamente.")
