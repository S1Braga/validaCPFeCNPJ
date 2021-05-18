Seu desafio será criar um serviço capaz de validar se o número de documento,
sendo um CPF ou CNPJ é válido. Ou seja, a partir do número-base do documento,
devemos calcular os dígitos verificadores e verificar se correspondem aos dígitos
verificadores informados na requisição.
Também deverá ser implementado um serviço que, dado um número base, irá
retornar os dígitos verificadores deste documento.
Importante: esses dois serviços serão disponibilizados para uso pelo site
shop.ifood.com.br, que possui grande volume de acessos, de forma que
performance e escalabilidade serão determinantes no desenho da solução.
O que esperamos que seja feito:
1. Um endpoint para validação do documento.
○ Formato:
/document/{document_number}/validation.
Exemplo:
○ /document/52587361052/validation
○ /document/59708149000172/validation
○ Retorno:
{
“document”: “52587361052”,
“valid”: true,
“document_type”: “INDIVIDUAL”
}
{
“document”: “59708149000172”,
“valid”: true,
“document_type”: “BUSINESS”
}Aplicação de Teste para Desenvolvedor
2. Um endpoint que, dado um número-base de um documento, calcula o
dígito verificador do documento.
○ Formato:
/document/{document_number}/check_digit.
Exemplo:
○ /document/525873610/check_digit
○ /document/597081490001/check_digit
○ Retorno:
{
“document_base”: “525873610”,
“check_digit”: 52,
“document_type”: INDIVIDUAL
}
{
“document_base”: “597081490001”,
“check_digit”: 72,
“document_type”: BUSINESS
}
