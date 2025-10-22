import java.util.ArrayList;

class Note {
    private String judul;
    private String keterangan;
    private Deadline deadline;

    public Note(String judul, String keterangan) {
        this.setJudul(judul);
        this.setKeterangan(keterangan);
    }

    public void addDeadline(Deadline deadline) {
        this.setDeadline(deadline);
    }

    public void showTodoList(Deadline today) {
        System.out.println("Judul: " + getJudul());
        System.out.println("Keterangan: " + getKeterangan());

        if (getDeadline() != null) {
            System.out.print("Deadline: ");
            getDeadline().showDeadline();
            getDeadline().daysLeft(today);
        } else {
            System.out.println("(Belum ada deadline)");
        }
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Deadline getDeadline() {
        return deadline;
    }

    public void setDeadline(Deadline deadline) {
        this.deadline = deadline;
    }
}

class Deadline {
    public static final int MAKE_ABSOLUT = -1;
    private String hari;
    private int tanggal;
    private String bulan;
    private int tahun;

    public Deadline(String hari, int tanggal, String bulan, int tahun) {
        this.setHari(hari);
        this.setTanggal(tanggal);
        this.setBulan(bulan);
        this.setTahun(tahun);
    }

    public void showDeadline() {
        System.out.println(getHari() + ", " + getTanggal() + " " + getBulan() + " " + getTahun());
    }

    public void daysLeft(Deadline today) {
        int selisih = getTanggal() - today.getTanggal();

        if (selisih > 0) {
            System.out.println("Sisa waktu: " + selisih + " hari lagi.");
        } else if (selisih == 0) {
            System.out.println("Deadline hari ini!");
        } else {
            System.out.println("Deadline sudah lewat " + lewatBatas(selisih) + " hari lalu.");
        }
    }

    private static int lewatBatas(int selisih) {
        return selisih * MAKE_ABSOLUT;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public int getTanggal() {
        return tanggal;
    }

    public void setTanggal(int tanggal) {
        this.tanggal = tanggal;
    }

    public String getBulan() {
        return bulan;
    }

    public void setBulan(String bulan) {
        this.bulan = bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public void setTahun(int tahun) {
        this.tahun = tahun;
    }
}

class TodoManager {
    private ArrayList<Note> notes;
    private Deadline today;

    public TodoManager() {
        notes = new ArrayList<>();
        today = new Deadline("Minggu", 12, "Oktober", 2025);
    }

    public void tambahCatatan(Note note) {
        notes.add(note);
    }

    public void tampilkanSemuaCatatan() {
        System.out.println("Tanggal Hari Ini: " + today.getTanggal() + " " + today.getBulan() + " " + today.getTahun());
        System.out.println();
        System.out.println("=== Daftar Catatan ===");

        for (int i = 0; i < notes.size(); i++) {
            System.out.print((i + 1) + ". ");
            notes.get(i).showTodoList(today);
            System.out.println("----------------------");
        }
    }
}

class Main {
    public static void main(String[] args) {
        TodoManager manager = new TodoManager();

        Note note1 = new Note("Nugas", "Demo Pemlan");
        Note note2 = new Note("Rapat", "Raval Mingguan");
        Note note3 = new Note("Jalan", "Ke pantai");
        Note note4 = new Note("Maksi", "Ke Prasmanan");

        note1.addDeadline(new Deadline("Senin", 14, "Oktober", 2025));
        note2.addDeadline(new Deadline("Rabu", 10, "Oktober", 2025));

        manager.tambahCatatan(note1);
        manager.tambahCatatan(note2);
        manager.tambahCatatan(note3);

        manager.tampilkanSemuaCatatan();
    }


}
