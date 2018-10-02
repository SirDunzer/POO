/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vdunz
 */
public class Personagem extends Atributos{
    private String nome;
    
    
    public Personagem(String nome, int forca, int dextreza, int constituicao, int inteligencia, int sabedoria, int carisma){
       super(forca,  dextreza,  constituicao, inteligencia,  sabedoria, carisma);
       this.nome = nome;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}


