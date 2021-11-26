package com.castores.controller;

import com.castores.modelos.Comentarios;
import com.castores.modelos.Persona;
import com.castores.modelos.Respuesta;
import com.castores.modelos.conectar;
import com.castores.modelos.publicacion;
import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

public class HomeController {

    private JdbcTemplate jdbcTemplate;
    int id;
    boolean coment = false;
    int idC;
    boolean responder = false;
    int personaRegistrada = 0;
    ModelAndView andView = new ModelAndView();
    int idpersonacomenta;
    int idRespuesta;

    public HomeController() {
        conectar c = new conectar();
        this.jdbcTemplate = new JdbcTemplate(c.conectar());
    }

    @RequestMapping("home.htm")
    public ModelAndView home() {

        String sql = "select n.* ,concat(p.nombre, ' ', p.appaterno, ' ', p.apmaterno) nombre from public.notas_publicadas n inner join persona p on n.idpersona = p.idpersona";
        String sqlComentario = "select c.* ,concat(p.nombre, ' ', p.appaterno, ' ', p.apmaterno) nombre from public.comentarios c inner join persona p on c.idpersona = p.idpersona";
        String sqlRespuestas = "select r.* ,concat(p.nombre, ' ', p.appaterno, ' ', p.apmaterno) nombre from public.respuestas r inner join persona p on r.idpersona = p.idpersona";
        List datos = this.jdbcTemplate.queryForList(sql);
        List datosComentarios = this.jdbcTemplate.queryForList(sqlComentario);
        List datosRespuesta = this.jdbcTemplate.queryForList(sqlRespuestas);

        andView.addObject("comentarios", datosComentarios);
        andView.addObject("datos", datos);
        andView.addObject("respuestas", datosRespuesta);
        andView.addObject("comentarB", coment);
        andView.addObject("respuestaB", responder);
        andView.addObject("iDP", id);
        andView.addObject("idC", idC);

        andView.setViewName("home");
        andView.addObject("publicacion", new publicacion());

        return andView;
    }

    @RequestMapping(value = "home.htm", method = RequestMethod.POST)
    public ModelAndView agregar(publicacion p) {
        System.out.println(p.getIdpersona());

        String sql = "INSERT INTO public.notas_publicadas(notapublicada, idpersona, fecha, hora) VALUES ('" + p.getNotapublicada() + "'," + p.getIdpersona() + ",now(),current_time)";
        System.out.println(sql);
        this.jdbcTemplate.update(sql);
        return new ModelAndView("redirect:home.htm");
    }

    /*  @RequestMapping(value = "comentar.htm", method = RequestMethod.GET)
    public ModelAndView comentar(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        id = Integer.parseInt(request.getParameter("id"));
        String sql = "select n.* ,concat(p.nombre, ' ', p.appaterno, ' ', p.apmaterno) nombre from public.notas_publicadas n inner join persona p on n.idpersona = p.idpersona where n.idnotapublicada = " + id;
        List datos = this.jdbcTemplate.queryForList(sql);
        String sqlComentarios = "select c.* ,concat(p.nombre, ' ', p.appaterno, ' ', p.apmaterno) nombre from public.comentarios c inner join persona p on c.idpersona = p.idpersona where c.idnotapublicada = " + id;
        List datosComentario = this.jdbcTemplate.queryForList(sqlComentarios);
        String sqlRespuestas = "select r.* ,concat(p.nombre, ' ', p.appaterno, ' ', p.apmaterno) nombre from public.respuestas r inner join persona p on r.idpersona = p.idpersona where r.idnotapublicada = " + id;
        List datosRespuestas = this.jdbcTemplate.queryForList(sqlRespuestas);
        System.out.println(datos);
        System.out.println(datosComentario);
        mav.addObject("datos", datos);
        mav.addObject("comentarios", datosComentario);
        mav.addObject("respuestas", datosRespuestas);
        return mav;
    }
     */
    @RequestMapping(value = "guardarComentario.htm", method = RequestMethod.POST)
    public ModelAndView agregarComentario(Comentarios c) {
        System.out.println(id);
        if (c.getComentario() != "") {
            String sql = "INSERT INTO public.comentarios(comentario, idpersona, idnotapublicada, fecha, hora) VALUES ('" + c.getComentario() + "'," + idpersonacomenta + ", " + id + ", now(), current_time)";
            System.out.println(sql);
            this.jdbcTemplate.update(sql);
            coment = false;
            return new ModelAndView("redirect:home.htm");
        } else {
            return new ModelAndView("redirect:home.htm");

        }

    }

    @RequestMapping("comentario.htm")
    public ModelAndView comentar(HttpServletRequest request) {
        id = Integer.parseInt(request.getParameter("id"));
        idpersonacomenta = Integer.parseInt(request.getParameter("idpersonacomenta"));
        coment = true;
        responder = false;
        return new ModelAndView("redirect:home.htm");

    }

    @RequestMapping("cancelarComentario.htm")
    public ModelAndView cancelarComentario() {
        coment = false;
        return new ModelAndView("redirect:home.htm");
    }

    @RequestMapping("responder.htm")
    public ModelAndView responder(HttpServletRequest request) {
        idC = Integer.parseInt(request.getParameter("id"));
        id = Integer.parseInt(request.getParameter("idPubli"));
        idRespuesta = Integer.parseInt(request.getParameter("idpersonaresponde"));
        responder = true;
        coment = false;
        return new ModelAndView("redirect:home.htm");

    }

    @RequestMapping(value = "agregarRespuesta.htm", method = RequestMethod.POST)
    public ModelAndView agregarRespuesta(Respuesta c) {
        System.out.println(c.getRespuesta());
        System.out.println(idC);
        if (c.getRespuesta() != "") {
            String sql = "INSERT INTO public.respuestas(respuesta, idpersona, idcomentario, idnotapublicada, fecha, hora) VALUES ( '" + c.getRespuesta() + "'," + idRespuesta + "," + idC + "," + id + ", now(), current_time);";
            System.out.println(sql);
            this.jdbcTemplate.update(sql);
            responder = false;
            return new ModelAndView("redirect:home.htm");
        } else {
            return new ModelAndView("redirect:home.htm");
        }

    }

    @RequestMapping("responderCancelar.htm")
    public ModelAndView cancelarRespuesta() {
        responder = false;
        return new ModelAndView("redirect:home.htm");
    }

    @RequestMapping(value = "registrar.htm", method = RequestMethod.GET)
    public ModelAndView registrar() {
        ModelAndView andView = new ModelAndView();
        andView.addObject(new Persona());
        andView.addObject("personaRegistrada", personaRegistrada);
        andView.setViewName("registrar");
        return andView;
    }

    @RequestMapping(value = "registrarPersona.htm", method = RequestMethod.POST)
    public ModelAndView registrarPersona(Persona p) {
        System.out.println(".------------"+p.getAppaterno());
        if (p.getApmaterno().isEmpty()   || p.getApmaterno().isEmpty()|| p.getNombre().isEmpty() || p.getDireccion().isEmpty() ||  p.getContrasenia().isEmpty() || p.getFechaingreso().isEmpty()) {
         return new ModelAndView("redirect:registrar.htm");
        }else{ 
        System.out.println(p.getFechaingreso());
        String sql = "INSERT INTO public.persona(appaterno, apmaterno, nombre, direccion, fechaingreso, esexterno, contrasenia) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        LocalDate date = LocalDate.parse(p.getFechaingreso());
        this.jdbcTemplate.update(sql, p.getApmaterno(), p.getApmaterno(), p.getNombre(), p.getDireccion(), date, p.isEsexterno(), p.getContrasenia());

        return new ModelAndView("redirect:index.htm");
        }
    }

    @RequestMapping(value = "entrar.htm", method = RequestMethod.GET)
    public ModelAndView entrar() {
        ModelAndView andView = new ModelAndView();
        andView.addObject(new Persona());
        andView.setViewName("index");
        return andView;
    }

    @RequestMapping(value = "entrarPersona.htm", method = RequestMethod.POST)
    public ModelAndView entrar(Persona p) {
        System.out.println(p.getNombre());
        String sql = "Select * from public.persona p where  p.nombre = '" + p.getNombre() + "' and p.appaterno = '" + p.getAppaterno() + "' and p.apmaterno = '" + p.getApmaterno() + "' and p.contrasenia = '" + p.getContrasenia() + "'";

        List personaIngreda = this.jdbcTemplate.queryForList(sql);
        if (personaIngreda.size() != 0) {
            System.out.println("id de la persona que ingresa " + personaIngreda.get(0));
            andView.addObject("personaIngresada", personaIngreda);
            return new ModelAndView("redirect:home.htm");
        } else {
            return new ModelAndView("redirect:index.htm");
        }

    }

}
