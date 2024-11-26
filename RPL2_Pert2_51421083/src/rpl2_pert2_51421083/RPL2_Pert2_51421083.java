package rpl2_pert2_51421083;

public class RPL2_Pert2_51421083 {

    public static void main(String[] args) {
        Mahasiswa mahasiswa = new Mahasiswa();

        mahasiswa.setName("Surya");
        mahasiswa.setNpm("51421083");
        mahasiswa.setClassNumber("4IA13");
        mahasiswa.setBirthYear(2004);
        mahasiswa.setAlamat("Kota Bekasi");

        System.out.println(mahasiswa.toString());
    }
}
