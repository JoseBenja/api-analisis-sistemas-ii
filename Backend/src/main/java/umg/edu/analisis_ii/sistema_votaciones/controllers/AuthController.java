package umg.edu.analisis_ii.sistema_votaciones.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import umg.edu.analisis_ii.sistema_votaciones.models.Usuario;
import umg.edu.analisis_ii.sistema_votaciones.security.AuthenticationRequest;
import umg.edu.analisis_ii.sistema_votaciones.security.AuthenticationResponse;
import umg.edu.analisis_ii.sistema_votaciones.security.JWTUtil;
import umg.edu.analisis_ii.sistema_votaciones.security.UsuarioDetailService;
import umg.edu.analisis_ii.sistema_votaciones.services.UsuarioServicio;


import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioDetailService usuarioDetailService;

    @Autowired
    private UsuarioServicio usuarioServicio;

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private static Logger logger
            = Logger.getLogger(
            AuthController.class.getName());
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {
        String contraseña = getContraseña(request.getUsername()); //obtiene la contraseña del usuario
        if (contraseña != null) { // si el usuario existe y la contraseña es correcta
            try {
                logger.log(Level.INFO, "se ejecuta el metodo createToken antes de authenticate");
                UserDetails userDetails = usuarioDetailService.loadUserByUsername(request.getUsername());
                logger.log(Level.INFO, "se ejecuta el metodo createToken despues de authenticate");
                String jwt = jwtUtil.generateToken(userDetails);
                String nombre = getCui(request.getUsername());
                String rol = getRol(request.getUsername());
                String nombreCompleto = getNombre(request.getUsername());
                return new ResponseEntity<>(new AuthenticationResponse(jwt, nombre, rol, nombreCompleto), HttpStatus.OK);
            } catch (BadCredentialsException e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }else{
            System.out.println("false");
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    //get nombre xd
    public String getDpi(String username){
        Optional<Usuario> usuario = usuarioServicio.findbyCorreo(username);
        String nombre = usuario.get().getNombre();
        return nombre;
    }

    public String getCui(String username){
        Optional<Usuario> usuario = usuarioServicio.findByCui(username);
        String cui = usuario.get().getCui();
        return cui;
    }

    public String getContraseña(String username){
        Optional<Usuario> usuario = usuarioServicio.findByCui(username);
        String contraseña = usuario.get().getPassword();
        return contraseña;
    }

    public String getRol(String username){
        Optional<Usuario> usuario = usuarioServicio.findByCui(username);
        String rol = usuario.get().getRol();
        return rol;
    }

    public String getNombre(String username){
        Optional<Usuario> usuario = usuarioServicio.findByCui(username);
        String nombre = usuario.get().getNombre();
        return nombre;
    }

}
