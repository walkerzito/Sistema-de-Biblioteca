
interface ItemBiblioteca {
  void emprestar();
  void devolver();
  boolean estaDisponivel();
}

abstract class Item implements ItemBiblioteca {
  private String titulo;
  private int anoPublicacao;
  private boolean emprestado;
  private String codigo;

public Item(String titulo, int anoPublicacao, String codigo) {
      this.titulo = titulo;
      this.anoPublicacao = anoPublicacao;
      this.emprestado = false;
      this.codigo = codigo;
  }

  public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}

public int getAnoPublicacao() {
    return anoPublicacao;
}

public void setAnoPublicacao(int anoPublicacao) {
    this.anoPublicacao = anoPublicacao;
}

public boolean isEmprestado() {
    return emprestado;
}

public void setEmprestado(boolean emprestado) {
    this.emprestado = emprestado;
}

public String getCodigo() {
    return codigo;
}

public void setCodigo(String codigo) {
    this.codigo = codigo;
}

@Override
    public void emprestar() {
        if (estaDisponivel()) {
            emprestado = true;
            System.out.println("Item emprestado: " + titulo);
        } else {
            System.out.println("Item indisponível para empréstimo: " + titulo);
        }
    }

    @Override
    public void devolver() {
        emprestado = false;
        System.out.println("Item devolvido: " + titulo);
    }

    @Override
    public boolean estaDisponivel() {
        return !emprestado;
    }
}

class Livro extends Item {
  private String autor;

  public String toString() {
    return "Livro: " + getTitulo() + " - " + getAutor();
}

  public Livro(String titulo, int anoPublicacao, String autor, String codigo) {
      super(titulo, anoPublicacao, codigo);
      this.autor = autor;
  }

  public String getAutor() {
      return autor;
  }

  public void setAutor(String autor) {
      this.autor = autor;
  }
}

class DVD extends Item {
  private String diretor;

  public DVD(String titulo, int anoPublicacao, String diretor, String codigo) {
      super(titulo, anoPublicacao, codigo);
      this.diretor = diretor;
  }
  
  public String toString() {
    return "DVD: " + getTitulo() + " - " + getDiretor();
}

  public String getDiretor() {
      return diretor;
  }

  public void setDiretor(String diretor) {
      this.diretor = diretor;
  }
}

class Biblioteca {
  private ItemBiblioteca[] itens;

  public Biblioteca(ItemBiblioteca[] itens) {
      this.itens = itens;
  }

  public void listarItensDisponiveis() {
      System.out.println("Itens disponíveis na biblioteca:");
      for (ItemBiblioteca item : itens) {
          if (item.estaDisponivel()) {
              System.out.println("- " + item.toString());
          }
      }
  }
}

