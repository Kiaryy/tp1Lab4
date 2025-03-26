package utn.supercell.TP1.DTO.Request;

public record EmpresaDTO( 
    String denominacion,
    String telefono,
    String horarioDeAtencion,
    String quienesSomos,
    String domicilio,
    String email,
    float latitud,
    float longitud
){
}
