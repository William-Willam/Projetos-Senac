#include <stdio.h> // Para operações de arquivo (fopen, fprintf, fclose)
#include <stdlib.h> // Para exit

int main() {
    FILE *arquivo_csv; // Ponteiro para o arquivo
    const char *nome_arquivo = "dados.csv"; // Nome do arquivo CSV

    // Abrir o arquivo no modo de escrita ("w")
    // Se o arquivo não existir, ele será criado. Se existir, seu conteúdo será sobrescrito.
    arquivo_csv = fopen(nome_arquivo, "w");

    // Verificar se houve erro ao abrir o arquivo
    if (arquivo_csv == NULL) {
        printf("Erro ao abrir o arquivo %s\n", nome_arquivo);
        return 1; // Retorna 1 para indicar erro
    }

    // Escrever o cabeçalho no arquivo CSV
    // "Nome", "Idade"
    fprintf(arquivo_csv, "Nome,Idade\n");

    // Escrever alguns dados
    fprintf(arquivo_csv, "Alice,30\n");
    fprintf(arquivo_csv, "Bob,24\n");
    fprintf(arquivo_csv, "Charlie,35\n");
    fprintf(arquivo_csv, "Maria,28\n");

    // Fechar o arquivo
    fclose(arquivo_csv);

    printf("Dados salvos com sucesso em %s\n", nome_arquivo);

    return 0; // Retorna 0 para indicar sucesso
}