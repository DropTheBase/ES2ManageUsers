import java.time.Year;

public class Utilizador {
    Integer id;
    String first_name;
    String last_name;
    String email;
    String genero;
    Year ano_entrada;


    public Utilizador(Integer id, String first_name, String last_name, String genero, String email, Year ano_entrada) {

        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.genero = genero;
        this.email = email;
        this.ano_entrada = ano_entrada;

    }


    public String getFirst_name(){ return first_name; }

    public void setFirst_name(String first_name) { this.first_name = first_name; }

    public String getLast_name(){ return last_name; }

    public void setLast_name(String last_name){ this.last_name = last_name; }

    public String getGenero(){ return genero; }

    public void setGenero(String genero){ this.genero = genero; }

    public String getEmail(){ return last_name; }

    public void setEmail(String email){ this.email = email; }

    public Year getAno_entrada() { return ano_entrada; }

    public void setAno_entrada(Year ano_entrada) {this.ano_entrada = ano_entrada; }

    public Integer getId() { return id; }

    public void setId(Integer id) {this.id = id;}

}

