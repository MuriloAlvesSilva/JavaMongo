import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {
	public static void main(String[] args) {
		
		//CRIA CONEXAO
		MongoClient client = new MongoClient();
		
		//CONECTA A INSTANCIA
		MongoDatabase bancoDeDados = client.getDatabase("test");
		
		//CONECATA NA COLLECTION
		MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
		
		//TRAS O PRIMEIRO DOCUMENTO		
		Document aluno = alunos.find().first();
		System.out.println(aluno);
		
		
		//Teste Git
		System.out.println("Teste GIT");
		
		/*
		//CRAI DOCUMENTO
		Document novoAluno = new Document("nome", "Roberto")
			.append("data_nascimento", new Date(2003, 10, 10))
			.append("curso", new Document("nome", "Letras"))
			.append("notas" , Arrays.asList(10,8,5))
			.append("habilidades", Arrays.asList(
					new Document().append("nome", "Inglês").append("nível", "Avançado"),
					new Document().append("nome", "Espanhol").append("nível", "Avançado"),
					new Document().append("nome",	 "Japonês").append("nível", "Básico")
		));
		
		
		
		//ADD DOCUMENTO
				alunos.insertOne(novoAluno);	
		*/
		
		/*
		//UPDATE DOCUMENTO
		alunos.updateOne(
				Filters.eq("nome","Joao"),
				new Document("$set", new Document("nome", "Joao Cana Brava"))
				);
		*/
		
		//DELETA DOCUMENTO
		alunos.deleteOne(
				Filters.eq("nome","Joao Cana Brava")
				);
		
		
		//FECHA CONEXAO
		client.close();
	}
}
