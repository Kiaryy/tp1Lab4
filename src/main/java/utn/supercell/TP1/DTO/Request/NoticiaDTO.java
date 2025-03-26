package utn.supercell.TP1.DTO.Request;

public record NoticiaDTO( 
    String tituloNoticia,
    String resumenNoticia,
    String imagenNoticia,
    String contenidoHTML,
    char publicada,
    Long empresa
){
}
