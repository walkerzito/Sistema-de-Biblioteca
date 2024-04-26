public class Demo {
  public static void main(String[] args) {
      Livro livro = new Livro("A Revolução dos Bichos", 1945, "George Orwell", "LIV001");
      DVD dvd = new DVD("Interestelar", 2014, "Christopher Nolan", "DVD001");

      ItemBiblioteca[] itens = {livro, dvd};
      Biblioteca biblioteca = new Biblioteca(itens);

      biblioteca.listarItensDisponiveis();

      livro.emprestar();
      dvd.emprestar();

      biblioteca.listarItensDisponiveis();

      livro.devolver();

      biblioteca.listarItensDisponiveis();
  }
}