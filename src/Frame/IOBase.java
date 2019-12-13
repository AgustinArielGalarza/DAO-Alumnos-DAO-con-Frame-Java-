package Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import personas.dto.PersonaDTO;
import personas.jdbc.*;

public class IOBase extends JFrame{
    
    private JLabel Etnombre,Etapellido,Etcurso, Etaula,Etescuela,EtId;
    private JTextField barraNom, barraApe, barraCurso, barraAula,barraEscuela,barraID;
    private JButton botonInsertar, botonDelete, botonActualizar;
    private JTable tabla;
    private PersonaDTO persona;
    private PersonaDao personaDao= new PersonaDaoJDBC();
    private List<PersonaDTO> lista;
    private Object [][] listaDoble;
    private String [] metaFilaPersona = {"ID de la Persona","Nombre de la persona","Apellido de la persona","Nombre del curso","Nombre del aula","Nombre de la Escuela"};
    
    
    public IOBase() throws Exception{
        setTitle("Proyecto DAO");
        setBounds(400, 200, 1400, 900);
        getContentPane().setBackground(Color.GRAY);
        JPanel superior = new JPanel();
        JPanel izquierda = new JPanel();
        JPanel inferior = new JPanel(new GridLayout(1,2));
        izquierda.setLayout(new GridLayout(10, 3));
        
        
        EtId = new JLabel("ID:");
        barraID= new JTextField(12);
        Etcurso = new JLabel("Curso:");
        barraCurso = new JTextField(12);
        Etaula = new JLabel("Aula:");
        barraAula = new JTextField(12);
        Etescuela = new JLabel("Escuela:");
        barraEscuela = new JTextField(12);
        Etnombre = new JLabel("Nombre :");
        barraNom = new JTextField(12);
        Etapellido = new JLabel("Apellido:");
        barraApe = new JTextField(12);
    
        lista = personaDao.select();
        listaDoble=personaDao.mostrar(lista);
        tabla = new JTable(listaDoble,metaFilaPersona);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        validate();
        
        botonInsertar = new JButton("Insertar");
        botonInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona = new PersonaDTO();
                try {
                    persona.setNombre(barraNom.getText());
                    persona.setApellido(barraApe.getText());
                    persona.setId_curso(Integer.parseInt(barraCurso.getText()));
                    persona.setId_aula(Integer.parseInt(barraAula.getText()));
                    persona.setEscuela(Integer.parseInt(barraEscuela.getText()));
                    personaDao.insert(persona);
                    lista = personaDao.select();
                    listaDoble=personaDao.mostrar(lista);
                    tabla = new JTable(listaDoble,metaFilaPersona); 
                    add(new JScrollPane(tabla), BorderLayout.CENTER);
                    
                    barraNom.setText("");
                    barraApe.setText("");
                    barraCurso.setText("");
                    barraAula.setText("");
                    barraEscuela.setText("");
                    validate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
       
        botonDelete = new JButton("Borrar");
        
        botonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id_borrar = Integer.parseInt(barraID.getText());
                    personaDao.delete(new PersonaDTO(id_borrar));
                    lista = personaDao.select();
                    listaDoble=personaDao.mostrar(lista);
                    tabla = new JTable(listaDoble,metaFilaPersona); 
                    add(new JScrollPane(tabla), BorderLayout.CENTER);
                    
                    barraID.setText("");
                    validate();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            
            }
        });
         
        botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                persona = new PersonaDTO();
                try {
                    persona.setId_persona(Integer.parseInt(barraID.getText()));
                    persona.setNombre(barraNom.getText());
                    persona.setApellido(barraApe.getText());
                    persona.setId_curso(Integer.parseInt(barraCurso.getText()));
                    persona.setId_aula(Integer.parseInt(barraAula.getText()));
                    persona.setEscuela(Integer.parseInt(barraEscuela.getText()));
                    personaDao.update(persona);
                    lista = personaDao.select();
                    listaDoble=personaDao.mostrar(lista);
                    tabla = new JTable(listaDoble,metaFilaPersona); 
                    add(new JScrollPane(tabla), BorderLayout.CENTER);
                    
                    barraID.setText("");
                    barraNom.setText("");
                    barraApe.setText("");
                    barraCurso.setText("");
                    barraAula.setText("");
                    barraEscuela.setText("");
                    validate();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
            }
        });
        
        
        izquierda.add(EtId);
        izquierda.add(barraID);
        izquierda.add(Etnombre);
        izquierda.add(barraNom);
        izquierda.add(Etapellido);
        izquierda.add(barraApe);
        izquierda.add(Etcurso);
        izquierda.add(barraCurso);
        izquierda.add(Etaula);
        izquierda.add(barraAula);
        izquierda.add(Etescuela);
        izquierda.add(barraEscuela);
        add(izquierda, BorderLayout.WEST);
        
        inferior.add(botonInsertar,BorderLayout.SOUTH);
        inferior.add(botonDelete, BorderLayout.SOUTH);
        inferior.add(botonActualizar, BorderLayout.SOUTH);
        add(inferior, BorderLayout.SOUTH);
    }
}
