class Perkusja {

    boolean talerze = true;
    boolean beben = true;

    void zagrajNaBebnie(){
        System.out.printf("bam bam baaa-aa-aam");
    }
    void zagrajNaTalerzach(){
        System.out.printf("brzdek brzdek brzdek");
    }
}

  class PerkusjaTester {
      public static void main(String[] args) {

          Perkusja p = new Perkusja();
          p.zagrajNaTalerzach();
          p.zagrajNaBebnie();
          p.beben = false;

          if (p.beben == true){
              p.zagrajNaBebnie();
          }
      }
  }
