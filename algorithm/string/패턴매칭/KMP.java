class KMP {

    // 우리는 패턴 전처리를 통해 매칭에 실패했을 때 돌아갈 곳을 미리 계산한다.
    // 패턴에서 접두사도 되고 접미사도 되는 문자열의 최대 길이를 저장해주는 table 을 생성한다.
    // table[]은 pattern 이 어디까지 일치했는지가 주어질 때 다음 시작 위치를 어디로 해야할지를 말해주기 때문에, 이를 흔히 부분 일치 테이블이라고 부른다.
    // 만약 리스트로 담아 위치를 반환해야할 때는 연결리스트말고 어레이리스트 쓰자
    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx=0;
        for(int i=1; i<n; i++) {
            // 일치하는 문자가 발생했을 때(idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
            while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if(pattern.charAt(i) == pattern.charAt(idx)) {
                table[i] = ++idx;
            }
        }
        return table;
    }
    static void find(String origin, String pattern) {
        int[] table = makeTable(pattern);

        int n1 = origin.length();
        int n2 = pattern.length();

        int idx = 0; // 현재 대응되는 글자 수
        for(int i=0; i< n1; i++) {
            // idx번 글자와 짚더미의 해당 글자가 불일치할 경우,
            // 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
            while(idx>0 && origin.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            // 글자가 대응될 경우
            if(origin.charAt(i) == pattern.charAt(idx)) {
                if(idx == n2-1) {
                    System.out.println("찾았습니다: 인덱스" + (i - idx) + "에서부터 " + (i) + "까지");
                    idx =table[idx];
                }else {
                    idx += 1;
                }
            }
        }
    }


    public static void main(String[] args) {
        String origin = "abacaaaduaismdbqiabacaaaoudyabaksabacaa";
        String pattern = "abacaa";

        // 문자열 검색
        KMP.find(origin, pattern);

        // 패턴의 부분일치테이블 출력해보기
        System.out.print("부분일치테이블 출력해보기: ");
        int[] table = KMP.makeTable(pattern);
        for(int i = 0 ; i < table.length ; i++) {
            System.out.print(table[i] + " ");
        }
        /*
찾았습니다: 인덱스0에서부터 5까지
찾았습니다: 인덱스17에서부터 22까지
찾았습니다: 인덱스33에서부터 38까지
부분일치테이블 출력해보기: 0 0 1 0 1 1         
         */
    }
}
