package ma.jit.proxibanque.metier;

import java.util.List;

import ma.jit.proxibanque.entities.Operation;

public interface IOperationMetier {

	public List<Operation> getAll();
	public Operation addOperation(Operation operation);
}
