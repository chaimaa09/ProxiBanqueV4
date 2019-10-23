package ma.jit.proxibanque.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.jit.proxibanque.entities.Operation;
import ma.jit.proxibanque.metier.IOperationMetier;

@RestController
@RequestMapping("/api")
public class OperationController {

	@Autowired
	IOperationMetier operationService;
	
	@GetMapping("/listeOperations")
	public List<Operation> getAllOperations(){
		return operationService.getAll();
	}
	
	@PostMapping("/listeOperation")
	public Operation addOperation(@RequestBody Operation operation){
		return operationService.addOperation(operation);
	}
}
