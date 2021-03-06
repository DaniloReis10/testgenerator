package entities;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

 /**
  * Questoes Value Object.
  * This class is value object representing database table Questoes 
  * This class is intented to be used together with associated Dao object.
  */

 /**
  * This sourcecode has been generated by FREE DaoGen generator version 2.4.1.
  * The usage of generated code is restricted to OpenSource software projects
  * only. DaoGen is available in http://titaniclinux.net/daogen/
  * It has been programmed by Tuomo Lukka, Tuomo.Lukka@iki.fi
  *
  * DaoGen license: The following DaoGen generated source code is licensed
  * under the terms of GNU GPL license. The full text for license is available
  * in GNU project's pages: http://www.gnu.org/copyleft/gpl.html
  *
  * If you wish to use the DaoGen generator to produce code for closed-source
  * commercial applications, you must pay the lisence fee. The price is
  * 5 USD or 5 Eur for each database table, you are generating code for.
  * (That includes unlimited amount of iterations with all supported languages
  * for each database table you are paying for.) Send mail to
  * "Tuomo.Lukka@iki.fi" for more information. Thank you!
  */



public class Questoes implements Cloneable, Serializable {

    /** 
     * Persistent Instance variables. This data is directly 
     * mapped to the columns of database table.
     */
    private int idquestao;
    private String questoes;
    private String respostas;
    
  



    /** 
     * Constructors. DaoGen generates two constructors by default.
     * The first one takes no arguments and provides the most simple
     * way to create object instance. The another one takes one
     * argument, which is the primary key of the corresponding table.
     */

    public Questoes () {

    }

    public Questoes (int idquestaoIn) {

          this.idquestao = idquestaoIn;

    }


    /** 
     * Get- and Set-methods for persistent variables. The default
     * behaviour does not make any checks against malformed data,
     * so these might require some manual additions.
     */

    public int getIdquestao() {
          return this.idquestao;
    }
    public void setIdquestao(int idquestaoIn) {
          this.idquestao = idquestaoIn;
    }

    public String getQuestoes() {
          return this.questoes;
    }
    public void setQuestoes(String questoesIn) {
          this.questoes = questoesIn;
    }

    public String getRespostas() {
          return this.respostas;
    }
    public void setRespostas(String respostasIn) {
          this.respostas = respostasIn;
    }
  



    /** 
     * setAll allows to set all persistent variables in one method call.
     * This is useful, when all data is available and it is needed to 
     * set the initial state of this object. Note that this method will
     * directly modify instance variales, without going trough the 
     * individual set-methods.
     */

    public void setAll(int idquestaoIn,
          String questoesIn,
          String respostasIn) {
          this.idquestao = idquestaoIn;
          this.questoes = questoesIn;
          this.respostas = respostasIn;
    }


    /** 
     * hasEqualMapping-method will compare two Questoes instances
     * and return true if they contain same values in all persistent instance 
     * variables. If hasEqualMapping returns true, it does not mean the objects
     * are the same instance. However it does mean that in that moment, they 
     * are mapped to the same row in database.
     */
    public boolean hasEqualMapping(Questoes valueObject) {

          if (valueObject.getIdquestao() != this.idquestao) {
                    return(false);
          }
          if (this.questoes == null) {
                    if (valueObject.getQuestoes() != null)
                           return(false);
          } else if (!this.questoes.equals(valueObject.getQuestoes())) {
                    return(false);
          }
          if (this.respostas == null) {
                    if (valueObject.getRespostas() != null)
                           return(false);
          } else if (!this.respostas.equals(valueObject.getRespostas())) {
                    return(false);
          }

          return true;
    }



    /**
     * toString will return String object representing the state of this 
     * valueObject. This is useful during application development, and 
     * possibly when application is writing object states in textlog.
     */
    public String toString() {
        StringBuffer out = new StringBuffer(this.getDaogenVersion());
        out.append("\nclass Questoes, mapping to table Questoes \n");
        out.append("Persistent attributes: \n"); 
        out.append("idquestao = " + this.idquestao + "\n"); 
        out.append("questoes = " + this.questoes + "\n"); 
        out.append("respostas = " + this.respostas + "\n"); 
        return out.toString();
    }


    /**
     * Clone will return identical deep copy of this valueObject.
     * Note, that this method is different than the clone() which
     * is defined in java.lang.Object. Here, the retuned cloned object
     * will also have all its attributes cloned.
     */
    public Object clone() {
        Questoes cloned = new Questoes();

        cloned.setIdquestao(this.idquestao); 
        if (this.questoes != null)
             cloned.setQuestoes(new String(this.questoes)); 
        if (this.respostas != null)
             cloned.setRespostas(new String(this.respostas)); 
        return cloned;
    }



    /** 
     * getDaogenVersion will return information about
     * generator which created these sources.
     */
    public String getDaogenVersion() {
        return "DaoGen version 2.4.1";
    }

}