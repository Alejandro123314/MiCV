package dad.MiCV;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;

import org.hildan.fxgson.FxGson;

import com.google.gson.Gson;

import dad.MiCV.model.CV;
import dad.MiCV.model.Nacionalidad;
import dad.MiCV.model.Personal;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Nacionalidad espanola = new Nacionalidad();
		
		Personal personal = new Personal();
		personal.setIdentificaion("12232434Z");
		personal.setNombre("Chuck");
		personal.setApellidos(null);
		personal.getNacionalidades().add(new Nacionalidad());
		personal.getNacionalidades().add(new Nacionalidad());
		personal.setPais("Estados Unidos");
		personal.setFechaNacimiento(LocalDate.of(1954, 11, 25));
		
		CV cv = new CV();
		cv.setPersonal(personal);
		
		Gson gson = FxGson.fullBuilder()
						.setPrettyPrinting()
						.create();
		
						String json = gson.toJson(cv, CV.class);
						File cvFile = new File("cv.json");
						
						Files.writeString(cvFile.toPath(), json, StandardCharsets.UTF_8);
												
		

	}

}
