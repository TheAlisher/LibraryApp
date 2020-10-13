package com.example.libraryapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.libraryapp.R;
import com.example.libraryapp.ui.models.BookModel;

import java.util.ArrayList;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private ArrayList<BookModel> card;
    private OnItemClickListener onItemClickListener;

    public BookAdapter(ArrayList<BookModel> card) {
        this.card = card;
        addItem();
    }

    private void addItem(){
        BookModel bookModel1 = new BookModel(
                R.drawable.image_book_1_prodavec,
                "Биография",
                "Продавец обуви. История компании Nike, рассказанная её основателем",
                "Фил Найт",
                "Nike – один из самых узнаваемых мировых брендов. " +
                        "Создатель компании – Фил Найт – один из богатейших людей, " +
                        "хотя еще в юности он не мог себе позволить купить кроссовки Adidas. " +
                        "50 лет назад студент Орегонского университета и бегун на средние дистанции " +
                        "Фил Найт занял у отца 50 баксов и начал перепродавать кроссовки из Японии. " +
                        "Сегодня годовой оборот компании Nike составляет 30 миллиардов долларов. " +
                        "А пара «найков» найдется в шкафу у каждого – от президента до подростка." +
                        "Фил Найт – человек-загадка, он редко дает интервью. Эта книга – исповедь о создании компании, ");
        BookModel bookModel2 = new BookModel(
                R.drawable.image_book_2_stive,
                "Биография",
                "Стив Джобс",
                "Уолтер Айзексон",
                "«Стив Джобс» — биография сооснователя корпорации Apple Стива Джобса, " +
                        "написанная американским журналистом и биографом Уолтером Айзексоном " +
                        "и опубликованная издательством «Simon & Schuster». Айзексон работал над книгой около трёх лет. ");
        BookModel bookModel3 = new BookModel(
                R.drawable.image_book_3_java,
                "Техническая литература",
                "Java. Полное руководство. Десятрое издание",
                "Герберт Шилдт",
                "В этом десятом издании справочного пособия, " +
                        "полностью обновленном с учетом последней версии Java SE 9, " +
                        "поясняется, как разрабатывать, компилировать, " +
                        "отлаживать и выполнять программы на языке программирования Java. " +
                        "Это пособие составлено Гербертом Шилдтом, автором популярных во всем мире книг по языкам программирования, " +
                        "таким образом, чтобы охватить все языковые средства Java, " +
                        "включая синтаксис, ключевые слова, основные принципы объектно-ориентированного программирования, " +
                        "значительную часть прикладного интерфейса Java API, библиотеки классов, аплеты и сервлеты, " +
                        "компоненты JavaBeans, библиотеки AWT и Swing, а также продемонстрировать их применение на простых и наглядных примерах. " +
                        "Не обойдены вниманием и новые средства, появившиеся в версии Java SE 9, в том числе модули и утилита JShell.");
        BookModel bookModel4 = new BookModel(
                R.drawable.image_book_4_samurai,
                "Литература по саморазвитию",
                "Самурай без меча: Побеждать не силой оружия, а силой разума",
                "Китами Масао",
                "Излагаются секреты лидерской мудрости легендарного исторического деятеля Японии XVI века Тоётоми Хидэёси," +
                        " которые с успехом могут быть применены в ХХІ веке.");
        BookModel bookModel5 = new BookModel(
                R.drawable.image_book_5_kak,
                "Литература по саморазвитию",
                "Как завоёвывать друзей и оказывать влияние на людей",
                "Дейл Карнеги",
                "«Как завоёвывать друзей и оказывать влияние на людей» — наиболее известная книга Дейла Карнеги, " +
                        "вышедшая 12 ноября 1936 года и изданная на многих языках мира. " +
                        "Книга представляет собой собрание практических советов и жизненных историй.");
        BookModel bookModel6 = new BookModel(
                R.drawable.image_book_6_magiya,
                "Литература по саморазвитию",
                "Магия утра. Как первый час дня определяет ваш успех",
                "Хэл Элрод",
                "Утренние ритуалы, которые предлагает осуществлять автор этой книги, " +
                        "помогли десяткам тысяч людей изменить свою жизнь," +
                        " почувствовать себя лучше и успевать больше. " +
                        "Для всех, кто хочет изменить свою жизнь, начав с малого – с первого часа каждого дня. ");
        card.add(bookModel1);
        card.add(bookModel2);
        card.add(bookModel3);
        card.add(bookModel4);
        card.add(bookModel5);
        card.add(bookModel6);
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_book_item, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        holder.onBind(card.get(position));
    }

    @Override
    public int getItemCount() {
        return card.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearCardBookItem;
        private ImageView imageBook;
        private TextView textBookCategory;
        private TextView textBookName;
        private TextView textBookAuthor;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            initializationViews(itemView);
            linearCardBookItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.OnItemClick(getAdapterPosition());
                }
            });
        }

        private void initializationViews(View itemView) {
            linearCardBookItem = itemView.findViewById(R.id.linear_cardBookItem);
            imageBook = itemView.findViewById(R.id.image_cardBookItem_book);
            textBookCategory = itemView.findViewById(R.id.text_cardBookItem_category);
            textBookName = itemView.findViewById(R.id.text_cardBookItem_name);
            textBookAuthor = itemView.findViewById(R.id.text_cardBookItem_author);
        }

        public void onBind(BookModel bookModel) {
            imageBook.setImageResource(bookModel.getImageBook());
            textBookCategory.setText(bookModel.getTextBookCategory());
            textBookName.setText(bookModel.getTextBookName());
            textBookAuthor.setText(bookModel.getTextBookAuthor());
        }
    }
}
