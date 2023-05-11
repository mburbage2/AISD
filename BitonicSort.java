public class BitonicSort
{
    /* Параметр dir указывает направление сортировки,
    по возрастанию или по убыванию; если (a[i] > a[j]) соответствует
    с направлением, то a[i] и a[j]
    меняются местами. */
    void compAndSwap(int a[], int i, int j, int dir)
    {
        if ( (a[i] > a[j] && dir == 1) ||
                (a[i] < a[j] && dir == 0))
        {
            // Замена элементов
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    /* Он рекурсивно сортирует битовую последовательность по возрастанию
    порядке, если dir = 1, и в порядке убывания в противном случае
    (означает, что dir=0). Последовательность, подлежащая сортировке, начинается с
    нижней позиции индекса, количество параметров равно числу
    из элементов, подлежащих сортировке.*/
    void bitonicMerge(int a[], int low, int count, int dir)
    {
        if (count>1)
        {
            int k = count/2;
            for (int i=low; i<low+k; i++)
                compAndSwap(a,i, i+k, dir);
            bitonicMerge(a,low, k, dir);
            bitonicMerge(a,low+k, k, dir);
        }
    }

    /* Эта функция сначала создает битоническую последовательность,
    рекурсивно сортируя две ее половины в порядке противоположной сортировки,
    а затем вызывает bitonic Merge, чтобы расположить их в
    том же порядке */
    void bitonicSort(int a[], int low, int count, int dir)
    {
        if (count>1)
        {
            int k = count/2;

            // Сортировка в порядке возрастания
            bitonicSort(a, low, k, 1);

            // Сортировка в порядке убывания
            bitonicSort(a,low+k, k, 0);

            // Объединяем всю последовательность в порядке возрастания
            bitonicMerge(a, low, count, dir);
        }
    }
    void sort(int a[], int N, int up)
    {
        bitonicSort(a, 0, N, up);
    }

}