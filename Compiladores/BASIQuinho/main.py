import sys
import logging # Importar logging para pegar o logger principal, se necessário
import logger_config # Importa para executar a configuração do logger
from compilador import Compilador

if __name__ == "__main__":
    # O logger já foi configurado por logger_config.py
    main_logger = logging.getLogger("BASIQuinhoCompilador") # Pega o logger principal

    if len(sys.argv) < 2:
        main_logger.error("Uso: python main.py <arquivo_fonte.bsq>")
        print("Uso: python main.py <arquivo_fonte.bsq>")
        sys.exit(1)

    arquivo_fonte = sys.argv[1]
    
    compilador_obj = Compilador(arquivo_fonte)
    sucesso = compilador_obj.compilar()

    if sucesso:
        main_logger.info("Processo de compilação finalizado com sucesso.")
    else:
        main_logger.error("Processo de compilação finalizado com erros.")
