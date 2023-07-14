package br.com.banco.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExeption extends  RuntimeException {

    //Retorna uma mensagem personalizada no erro NOTFOUD 404
    public NotFoundExeption(String message){

        super(message);
    }

}
