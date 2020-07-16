package com.app.helpers.excecoes;

/**
 *
 * @author Rodolfo
 */
public class excMessages {

    //FORMATCAO
    public static final String STR_DATA_REGISTRO_MAIOR_DATA_ATUAL = "A Data de Registro não pode ser superior a Data Atual.";
    public static final String STR_DATA_PERIODO = "A Data de Início deve ser anterior a Data Fim.";
    public static final String STR_DATA_INVALIDA = "A data informada no campo não é válida.";
    public static final String STR_HORA_PERIODO_INVALIDO = "A Hora de Entrada deve ser anterior a Hora de Saida.";

    //CRUDS
    public static final String STR_REG_JA_EXISTE = "Os dados informados já estão cadastrados.";
    public static final String STR_REG_NAO_EXISTE = "Os dados informados não foram localizados ou não estão cadastrados no sistema.";
    public static final String STR_DADOS_OBRIGATORIOS = "Os campos obrigatórios devem ser informados.";
    public static final String STR_DADOS_VALIDOS = "Os valores devem ser válidos, ou maiores que zero.";
    public static final String STR_SISTEMA_NAO_EXISTE = "Sistema de Origem informado, não foi localizado ou não esta cadastrado.";

    public static final String STR_OPERACAO_SUCESSO = "A operação foi realizada com sucesso";
    public static final String STR_OPERACAO_INSUCESSO = "A operação não pode ser realizada";

    //registro sucesso entity
    public static final String STR_REG_USUARIO_SUCESSO = "Usuário registrado com sucesso";
    public static final String STR_REG_PESSOA_SUCESSO = "Pessoa registrada com sucesso";
    public static final String STR_REG_SISTEMA_SUCESSO = "Sistema registrado com sucesso";
    public static final String STR_REG_LOG_SUCESSO = "Log registrado com sucesso";
    public static final String STR_REG_USUARIO_ALTERAR_SENHA_SUCESSO = "Senha alterada com sucesso";

    //removido sucesso entity
    public static final String STR_DEL_USUARIO_SUCESSO = "Usuário removido do sistema com sucesso";
    public static final String STR_DEL_PESSOA_SUCESSO = "Pessoa removida do sistema com sucesso";
    public static final String STR_DEL_SISTEMA_SUCESSO = "Sistema removido do sistema com sucesso";
    public static final String STR_DEL_LOG_SUCESSO = "Log removido do sistema com sucesso";

    //SERVICES
    public static final Integer STATUS_OK = 200;
    public static final Integer STATUS_CREATE = 201;
    public static final Integer STATUS_NO_CONTENT = 204;
    public static final Integer STATUS_BAD_REQUEST = 400;
    public static final Integer STATUS_NOT_FOUND = 404;
    public static final Integer STATUS_INTERNAL_SERVER_ERROR = 500;
    public static final Integer STATUS_NOT_IMPLEMENTED = 501;
    public static final Integer STATUS_SERVICE_UNAVAILABLE = 503;

    //UTILITÁRIOS
    public static final String STR_EMAIL_SUCESSO = "O email foi enviado com sucesso";
    public static final String STR_EMAIL_INSUCESSO = "O email não pode ser enviado";
    public static final String STR_EMAIL_NAO_CADASTRADO = "O email informado não esta registrado no sistema.";
}
