#include <stdio.h>
#include <string.h>

typedef struct
{
  char nome[100];
  char regiao;
  int distancia;  
} Aluno;

void preencherVetor(Aluno alunos[], int n){
    char lixo;
    for(int i = 0; i < n; i++){
        Aluno novoAluno;
        scanf("%s", &novoAluno.nome);
        scanf("%c", &lixo);
        scanf("%c", &novoAluno.regiao);
        scanf("%d", &novoAluno.distancia);

        alunos[i] = novoAluno;
    }
}

void ordenar(Aluno alunos[], int esq, int dir){
    int i = esq;
    int j = dir;

    Aluno pivo = alunos[(esq+dir) / 2];

    while(i <= j){

        while(alunos[i].distancia <= pivo.distancia){
            if(alunos[i].distancia == pivo.distancia){
                if(alunos[i].regiao <= pivo.regiao){
                    if(alunos[i].regiao == pivo.regiao){
                        if(strcmp(alunos[i].nome,pivo.nome) < 0){
                            i++;
                        }else{
                            break;
                        }
                    }else{
                        i++;
                    }
                }else{
                    break;
                }
            }else{
                i++;
            }
        }

        while(alunos[j].distancia >= pivo.distancia){
            if(alunos[j].distancia == pivo.distancia){
                if(alunos[j].regiao >= pivo.regiao){
                    if(alunos[j].regiao == pivo.regiao){
                        if(strcmp(alunos[j].nome,pivo.nome) > 0){
                            j--;
                        }else{
                            break;
                        }
                    }else{
                        j--;
                    }
                }else{
                    break;
                }
            }else{
                j--;
            }
        }

        if(i <= j){
            Aluno tmp = alunos[i];
            alunos[i] = alunos[j];
            alunos[j] = tmp;
            j--;
            i++;
        }
    }

    if (i < dir){
        ordenar(alunos, i,dir);
    }

    if(j > esq){
        ordenar(alunos,esq, j);
    }
}


int main(){
    int quantAlunos;
    scanf("%d", &quantAlunos);
    //printf("%d", quantAlunos);
    Aluno alunos[quantAlunos];
    preencherVetor(alunos, quantAlunos);
    ordenar(alunos,0,quantAlunos);

    for(int i = 0; i < quantAlunos; i++){
        printf("%s\n", alunos[i].nome);
    }
}