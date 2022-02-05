/*
라빈카프 알고리즘의 핵심은 비교를 위해 해시값을  이용한다는 것이다.
패턴 내의 문자들을 일일이 비교하는게 아니라 패턴과 본문의 하위 문자열에 대한 해시값을 비교한다.
하위 문자열을 해시할 때 하위 문자열 전체를 매번 해시하면 시간이 오래걸리므로 앞 문자에 해당하는 값을 빼고 뒤에 값을 추가하는 형태로 새로 해시값을 구한다.
만약 문자열 패턴을 검색하는 것이라면 해시 충돌이 발생해 실제 패턴이 일치하지 않을 수 있으므로 해시값이 일치하다면 또 한번 문자열이 일치하는지 검사를 해주어야 한다.

해시값이 일치하면 진짜 문자열이 일치하는지 검사하므로
origin: aaa........aa
pattern: aaaa....aaaaaaaaaaaaaaaaaaaa
해시값이 일치하면 진짜 문자열이 일치하는지 검사하므로 이런 형태로 패턴 길이가 엄청 길고 충돌이 자주 일어나는경우 시간초과 뜰수도
 */
class RabinKarp {
    public static void main(String[] args) {
        RabinKarp rk = new RabinKarp();
        List<Integer> pos = rk.search("niceasdanicesdni cesanicenice", "nice");

        System.out.println(pos); // pos부터 패턴사이즈만큼 더해주면 시작과 끝 위치 알 수 있음
        //[0, 8, 21, 25]
    }
    public List<Integer> search(String origin, String pattern) {
        int n = origin.length();
        int m = pattern.length();
        List<Integer> findAt = new ArrayList<>();
        int Shash = 0, Phash = 0, base = 1;
// get hash value
        for (int i = m - 1; i >= 0; i--)
        {
            Shash = Shash + origin.charAt(i) * base;
            Phash = Phash + pattern.charAt(i) * base;
            if (i > 0)
                base *= 371;
        }
        for (int i = 0; i < n - m + 1; i++)
        {
            if (i > 0)
                Shash = (Shash - origin.charAt(i - 1) * base) * 371 + origin.charAt(m - 1 + i);
            if (Phash == Shash)
            {
                boolean find = true;
                for (int j = 0; j < m; j++) {
                    if (origin.charAt(i + j) != pattern.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                if (find) {
                    findAt.add(i);
                }
            }
        }
        return findAt;
    }
}
