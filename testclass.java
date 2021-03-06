import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zhengkuang on 9/23/17.
 */
public class testclass {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||k<=0||nums.length==0) return new int[0];
        int[] answer=new int[nums.length-k+1];
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<k;i++){
            add(list,nums,i);
        }
        answer[0]=nums[list.peekFirst()];
        int index=1;
        for(int i=k;i<nums.length;i++){
            add(list,nums,i);
            answer[index++]=shrink(list,nums,i-k);
        }
        HashSet<Integer> set=new HashSet<>();
        return answer;
    }

    public int add(LinkedList<Integer> list,int[] nums, int i){
        while(list.peekLast()!=null&&nums[i]>=nums[list.peekLast()]){
            list.pollLast();
        }
        list.addLast(i);
        return nums[list.peekFirst()];
    }

    public int shrink(LinkedList<Integer> list, int[] nums,int index){
        if(index>=list.peekFirst()){
            list.pollFirst();
        }
        return nums[list.peekFirst()];
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<>(wordList);
        HashSet<String> samelevel=new HashSet<>();
        if(wordSet.contains(beginWord)) wordSet.remove(beginWord);

        List<List<String>> rlist=new ArrayList<>();

        if(!wordSet.contains(endWord)) return rlist;

        Queue<String> depthqueue=new LinkedList<>();
        HashMap<String,List<List<String>>> listsMap=new HashMap<>();
        HashMap<String,String> preMap=new HashMap<>();

        preMap.put(beginWord,beginWord);
        List<List<String>> beginLists=new ArrayList<>();
        beginLists.add(new ArrayList<String>());
        listsMap.put(beginWord,beginLists);

        depthqueue.offer(beginWord);
        boolean stop=false;
        while(depthqueue.size()!=0){
            int size=depthqueue.size();
            for(int i=0;i<size;i++){
                String curWord=depthqueue.poll();
                if(curWord.equals(endWord)) stop=true;
                wordSet.remove(curWord);
                String preWord=preMap.get(curWord);
                List<List<String>> lists=listsMap.get(preWord);
                //Deep Copy
                List<List<String>> copyList=new ArrayList<>();
                for(List<String> outer:lists){
                    List<String> copyouter=new ArrayList<>();
                    for(String inner:outer){
                        copyouter.add(inner);
                    }
                    copyList.add(copyouter);
                }
                for(List<String> tmp:copyList){
                    tmp.add(curWord);
                }
                listsMap.put(curWord,copyList);

                for(int k=0;k<curWord.length();k++){
                    char[] array=curWord.toCharArray();
                    for(char c='a';c<'z';c++){
                        array[k]=c;
                        String change=new String(array);
                        if(wordSet.contains(change)&&!samelevel.contains(change)){
                            if(change.equals(endWord)){
                                stop=true;
                            }
                            depthqueue.offer(change);
                            samelevel.add(change);
                            preMap.put(change,curWord);
                        }
                    }
                }
                preMap.remove(curWord);
            }
            if(stop){
                    for(String keys:listsMap.keySet()){
                        if(near(keys,endWord)){
                            for(List<String> answer:listsMap.get(keys)){
                                answer.add(endWord);
                                rlist.add(answer);
                            }
                        }
                    }
                    return rlist;
            }
        }
        return rlist;
    }
    public static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> answer=new ArrayList<>();
        if(intervals==null) return answer;
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start<i2.start) return -1;
                else if(i1.start==i2.start) return 0;
                else return 1;
            }
        });
        for(Interval i:intervals){
            if(answer.size()==0) answer.add(i);
            else{
                Interval last=answer.get(answer.size()-1);
                if(last.end>=i.start){
                    if(last.end>=i.end){
                        ;
                    }
                    else{
                        last.end=i.end;
                    }
                }
                else{
                    answer.add(i);
                }
            }
        }

        return answer;

    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        class node{
            int key;
            int fre;
            public node(int key,int fre){
                this.key=key;
                this.fre=fre;
            }
        }
        List<Integer> answer=new ArrayList<>();
        if(nums==null||nums.length==0||k<=0) return answer;
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        for(int n:nums){
         //   map.put(n,map.getOrDefault(n,0)+1);
            max=Math.max(max,map.get(n));
        }
        PriorityQueue<node> queue=new PriorityQueue<node>(2,new Comparator<node>(){
            public int compare(node i1,node i2){
                if(i1.fre>i2.fre) return 1;
                else return -1;
            }
        });
        int count=0;
        for(Integer i:map.keySet()){
            if(count<k) queue.add(new node(i,map.get(i)));
            else{
                if(map.get(i)>queue.peek().fre) queue.add(new node(i,map.get(i)));
            }
            count++;
        }
        while(queue.size()!=0){
            answer.add(queue.poll().key);
        }
        return answer;
    }

    public boolean near(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i)) count++;
        }
        return count==1;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet=new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        int step=0;
        while(queue.size()!=0){
            int size=queue.size();
            int numberOfAdd=0;
            for(int i=0;i<size;i++){
                String cur=queue.poll();
                int wordLength=cur.length();
                for(int j=0;j<wordLength;j++){
                    char[] array=cur.toCharArray();
                    for(char k='a';k<='z';k++){
                        array[j]=k;
                        String change=new String(array);
                        if(change.equals(cur)) continue;
                        if(wordSet.contains(change)) {
                            numberOfAdd++;
                            if(change.equals(endWord)) return step+2;
                            queue.add(change);
                        }
                    }
                }
                wordSet.remove(cur);
            }
            if(numberOfAdd==0) return 0;
            step++;
        }
        return 0;
    }


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses<=0||prerequisites==null) return false;
        int[] indegree=new int[numCourses];
        HashMap<Integer,List<Integer>> canTake=new HashMap<>();


        for(int i=0;i<prerequisites.length;i++){
            if(canTake.get(prerequisites[i][1])==null){
                canTake.put(prerequisites[i][1],new ArrayList<Integer>());
            }
            canTake.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0) queue.add(i);
        }

        while(queue.size()!=0){
            Integer top=queue.poll();
            System.out.println("The top is"+top);
            if(canTake.get(top)!=null){
                for(Integer course:canTake.get(top)){
                    System.out.println("The course is"+course);
                    indegree[course]--;
                    System.out.println("The degree is"+indegree[course]);
                    if(indegree[course]==0) queue.add(course);
                }
            }
        }


        for(int i:indegree){
            if(i!=0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
  /*      PriorityQueue<Integer> queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2) return 1;
                else return -1;
            }
        });

        queue.add(5);
        queue.add(4);
        queue.add(6);
        queue.add(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        String begin="catch";
        String end="choir";
        int[] nums=new int[]{1,1,1,2,2,3};
        String[] alist=new String[]{"tours","awake","goats","crape","boron","payee","waken","cares","times","piled","maces","cuter","spied","spare","mouse","minty","theed","sprat","veins","brian","crown","years","drone","froth","foggy","laura","sears","shunt","gaunt","hovel","staff","child","arson","haber","knows","rubes","czars","pawed","whine","treed","bauer","jodie","timed","flits","robby","gooks","yawls","purse","veeps","tints","taped","raced","shaft","modes","dykes","slims","parts","emile","frail","salem","jives","heave","bayer","leech","clipt","yanks","wilds","hikes","cilia","spiel","mulls","fetal","homed","drown","suite","defer","oaken","flail","zippy","burke","slued","mowed","manes","verse","serra","bruno","spoke","mikes","hafts","breed","sully","croce","boers","chair","thong","pulse","pasta","perot","fices","shies","nadir","every","diets","roads","cones","tuned","globs","graft","stall","royal","fixes","north","pikes","slack","vests","quart","crawl","tangs","calks","mayor","filmy","barns","block","hoods","storm","cedes","emote","tacks","skirt","horsy","mawed","moray","wring","munch","hewed","hooke","batch","drawl","berth","sport","welch","jeans","river","tabby","amens","stump","cause","maced","hiker","spays","dusty","trail","acorn","zooms","puked","clown","sands","kelli","stein","rawer","water","dolts","momma","fluky","scots","pupil","halls","toady","pored","latch","shags","union","tamps","stead","ryder","knoll","cacao","damns","charm","frank","draws","gowns","risen","saxes","lucks","avert","yolks","clime","wedge","ruses","famed","sabik","gravy","anion","veils","pyres","raspy","lofts","tress","showy","percy","rices","taker","roger","yeats","baked","ayers","fazes","curly","shawn","clare","paine","ranks","hocks","berta","plays","parks","tacos","onion","skeet","acton","lamer","teals","reset","steal","maven","sored","fecal","harsh","totem","swoop","rough","jokes","mires","weird","quits","damps","touts","fling","sarah","peeps","waxen","traps","mange","swell","swoon","catch","mower","bonny","finds","yards","pleas","filed","smelt","drams","vivid","smirk","whigs","loafs","opens","meter","hakes","berms","whack","donny","faint","peace","libby","yates","purer","wants","brace","razed","emend","bards","karyn","japed","fated","missy","punks","humps","steak","depth","brunt","hauls","craws","blast","broom","tones","ousts","wires","peeks","ruffs","crack","monte","worth","spans","tonic","runny","erick","singe","maine","casts","jello","realm","haste","utter","bleat","kasey","palms","solos","hoagy","sweep","loner","naves","rhine","acmes","cadet","dices","saris","mauro","fifty","prows","karat","dowel","frays","shorn","sails","ticks","train","stars","stork","halts","basal","glops","beset","rifer","layla","lathe","daffy","jinns","snide","groin","kelly","zincs","fryer","quilt","drama","shook","swami","hulls","swazi","danes","axons","those","lorry","plath","prime","faces","crock","shake","borer","droop","derek","shirk","styed","frown","jells","slows","lifts","jeers","helms","turds","dross","tired","rimes","beats","dingo","crews","bides","loins","furry","shana","wises","logos","aural","light","pings","belch","campy","swish","sangs","nerds","boggy","skies","weals","snags","joyed","mamet","miser","leaks","ramos","tract","rends","marks","taunt","sissy","lipid","beach","coves","fates","grate","gloss","heros","sniff","verve","tells","bulge","grids","skein","clout","leaps","males","surfs","slips","grave","boats","tamed","muled","meier","lower","leafy","stool","reich","rider","iring","ginny","flaks","chirp","tonga","chest","ollie","foxes","links","alton","darth","drier","sated","rails","gyros","green","jenna","cures","veals","sense","sworn","roses","aides","loses","rival","david","worms","stand","track","dales","noyes","fraud","shock","sward","pluto","biked","roans","whiny","halve","bunts","spilt","gamey","deeds","oozed","ruder","drano","sages","fewer","maize","aimed","bails","poole","hunts","shari","champ","shuns","jonah","faced","spook","harry","lagos","peale","nacho","saint","power","chaff","shard","cocky","irate","tummy","withe","forks","bates","stuns","turfs","coped","coups","vince","helps","facet","fezes","outer","cheek","tried","sumps","fakes","fonds","yearn","brays","flute","fetid","beyer","mamma","topic","bouts","trend","gorey","hills","swaps","sexes","cindy","ruler","kited","gaits","shank","cloys","stuck","purus","musks","gouge","brake","biker","layer","lilly","bills","seven","flyer","phase","wowed","beaus","cokes","chimp","spats","mooch","dried","hulks","shift","galen","wiped","clops","decal","nopes","huffs","lades","sunny","foyer","gusty","wormy","chips","focus","pails","solid","ariel","gamed","diver","vying","sacks","spout","sides","agave","bandy","scant","coils","marci","marne","swank","basil","shine","nines","clues","fuzes","jacks","robin","pyxes","later","silas","napes","homes","baled","dames","abuse","piker","coots","tiles","bents","pearl","booty","hells","dusky","glare","scale","pales","leary","scull","bimbo","mossy","apron","manet","opted","kusch","shiny","argos","hoped","towns","bilbo","slums","skull","shale","mandy","scows","speed","eager","lards","crows","merry","anted","faxed","leave","fargo","creek","comas","golda","baize","easts","plied","rared","ashed","doted","bunin","bonds","yarns","latin","right","worst","sixes","gabby","begun","upend","giant","tykes","creak","manor","bosom","riced","dimly","holes","stunt","parsi","peers","snell","mates","jules","rusty","myles","yules","sades","hobbs","booth","clean","liven","gamer","howdy","stray","riser","wisps","lubes","tubes","rodeo","bigot","tromp","pimps","reeve","pumps","dined","still","terms","hines","purrs","roast","dooms","lints","sells","swims","happy","spank","inset","meany","bobby","works","place","brook","haded","chide","slime","clair","zeros","britt","screw","ducal","wroth","edger","basie","benin","unset","shade","doers","plank","betsy","bryce","cross","roped","weans","bliss","moist","corps","clara","notch","sheep","weepy","bract","diced","carla","locks","sawed","covey","jocks","large","pasts","bumps","stile","stole","slung","mooed","souls","dupes","fairs","lined","tunis","spelt","joked","wacky","moira","strut","soled","pints","axing","drank","weary","coifs","wills","gibes","ceded","gerry","tires","crazy","tying","sites","trust","dover","bolds","tools","latex","capet","lanky","grins","brood","hitch","perts","dozes","keels","vault","laius","chung","deres","glove","corms","wafer","coons","ponce","tumid","spinx","verge","soggy","fleas","middy","saiph","payer","nukes","click","limps","oared","white","chart","nasty","perth","paddy","elisa","owing","gifts","manna","ofter","paley","fores","sough","wanda","doggy","antic","ester","swath","spoon","lamas","meuse","hotel","weedy","quads","paled","blond","flume","pried","rates","petal","rover","marsh","grief","downy","pools","buffs","dunne","cruel","finny","cosby","patch","polly","jerks","linen","cider","visas","beard","mewed","spill","trots","tares","pured","prior","build","throe","wends","baned","mario","misty","golds","lacey","slags","jived","finis","inner","money","skews","sunks","fined","bauds","lapel","class","berne","rabin","roils","hyped","styes","evans","towed","hawed","allow","modal","ports","erich","rills","humid","hooks","sedge","shirt","nippy","fundy","runes","smile","dolly","tisha","byers","goths","sousa","mimed","welts","hoots","shown","winds","drays","slams","susan","frogs","peach","goody","boned","chewy","eliza","peary","pyxed","tiled","homer","tokes","verdi","mabel","rolls","laden","loxed","phony","woods","brine","rooks","moods","hired","sises","close","slops","tined","creel","hindu","gongs","wanes","drips","belly","leger","demon","sills","chevy","brads","drawn","donna","glean","dying","sassy","gives","hazes","cores","kayla","hurst","wheat","wiled","vibes","kerry","spiny","wears","rants","sizer","asses","duked","spews","aired","merak","lousy","spurt","reeds","dared","paged","prong","deere","clogs","brier","becks","taken","boxes","wanna","corny","races","spuds","jowls","mucks","milch","weest","slick","nouns","alley","bight","paper","lamps","trace","types","sloop","devon","pedal","glint","gawky","eaves","herbs","felts","fills","naval","icing","eking","lauds","stats","kills","vends","capes","chary","belle","moats","fonts","teems","wards","bated","fleet","renal","sleds","gases","loony","paced","holst","seeds","curie","joist","swill","seats","lynda","tasks","colts","shops","toted","nuder","sachs","warts","pupal","scalp","heirs","wilma","pansy","berra","keeps","menus","grams","loots","heels","caste","hypes","start","snout","nixes","nests","grand","tines","vista","copes","ellis","narks","feint","lajos","brady","barry","trips","forth","sales","bests","hears","twain","plaid","hated","kraft","fared","cubit","jayne","heats","chums","pangs","glows","lopez","vesta","garbo","ethel","blood","roams","mealy","clunk","rowed","hacks","davit","plane","fuses","clung","fitch","serer","wives","lully","clans","kinks","spots","nooks","plate","knits","greet","loads","manic","scone","darin","pills","earth","gored","socks","fauna","ditch","wakes","savvy","quiet","nulls","sizes","diana","mayan","velds","dines","punch","bales","sykes","spiky","hover","teats","lusts","ricky","think","culls","bribe","pairs","month","cored","packs","lobes","older","hefts","faxes","cased","swain","bawdy","troop","woven","stomp","swags","beads","check","shill","broad","souse","pouch","lived","iambs","teaks","clams","outed","maxed","plain","sappy","cabal","penal","shame","budge","offed","kooks","gybed","basin","thoth","arced","hypos","flows","fetch","needs","davis","jared","bongo","added","sames","randy","tunes","jamar","smash","blows","grows","palmy","miler","chins","viola","tower","cream","molls","cello","sucks","fears","stone","leans","zions","nutty","tasha","ratty","tenet","raven","coast","roods","mixes","kmart","looms","scram","chapt","lites","trent","baron","rasps","ringo","fazed","thank","masts","trawl","softy","toils","romes","norma","teens","blank","chili","anise","truss","cheat","tithe","lawns","reese","slash","prate","comet","runts","shall","hosed","harpy","dikes","knock","strip","boded","tough","spend","coats","husky","tyree","menes","liver","coins","axles","macho","jawed","weeps","goods","pryor","carts","dumps","posts","donor","daunt","limbo","books","bowls","welds","leper","benny","couch","spell","burst","elvin","limbs","regal","loyal","gaily","blade","wheal","zests","seine","hubby","sheen","tapes","slugs","bench","lungs","pipes","bride","selma","berry","burns","skins","bowen","gills","conan","yucky","gauls","voled","crust","jerky","moans","plump","sided","disks","gleam","larry","billy","aloud","match","udder","rises","wryer","deter","cling","brisk","lever","chaps","tansy","gland","rocky","lists","joins","tubed","react","farsi","dopes","chats","olsen","stern","gully","youth","wiles","slink","cooke","arise","bores","maims","danny","rives","rusts","plots","loxes","troys","cleat","waxes","booze","haven","dilly","shaun","gasps","rains","panda","quips","kings","frets","backs","arabs","rhino","beets","fiber","duffy","parry","sever","hunks","cheap","beeps","fifes","deers","purls","hello","wolfs","stays","lands","hawks","feels","swiss","tyros","nerve","stirs","mixed","tombs","saves","cater","studs","dorky","cinch","spice","shady","elder","plato","hairs","newts","slump","boots","lives","walls","spunk","bucks","mined","parch","disco","newel","doris","glues","brawn","abner","piked","laxes","bulky","moran","cozen","tinge","dowry","snare","sagan","harms","burch","plows","sunni","fades","coach","girls","typed","slush","saver","bulls","grass","holed","coven","dukes","ocher","texan","cakes","gilts","jenny","salon","divas","maris","costs","sulla","lends","gushy","pears","teddy","huffy","sited","rhone","euler","solve","grace","snarl","taste","sally","allay","suers","bogey","pooch","songs","cameo","molts","snipe","cargo","forge","reins","hoses","crams","fines","tings","wings","spoor","twice","waxed","mixer","bongs","stung","gages","yelps","croci","corks","bolls","madge","honer","riled","camus","trick","bowed","overt","steed","ripes","stave","crick","great","scott","scald","point","finch","bulks","chant","kiddo","cover","drunk","sered","dicky","wider","saith","mutts","blind","lyres","sized","darby","rebel","zones","title","yawns","laths","sting","taine","paris","route","livia","roots","belay","daubs","spoof","camel","colds","foist","saned","doles","slays","woody","leads","stout","caper","erika","lance","earns","vines","mercy","antis","terri","messy","lords","shims","serfs","jinni","caged","threw","rainy","bumpy","arias","wails","romeo","gorge","dolls","risks","skyed","fumes","payed","mites","choir","piles","scene","flake","solon","brahe","bikes","dawes","goofs","payne","cried","slavs","hives","snack","cribs","aways","fired","swarm","pumas","paved","smith","gooey","liefs","safer","banes","slake","doled","dummy","gazed","heaps","loped","scoff","crash","balmy","hexed","lunch","guide","loges","alien","rated","stabs","whets","blest","poops","cowls","canes","story","cunts","tusks","pinto","scats","flier","chose","brute","laked","swabs","preps","loose","merle","farms","gapes","lindy","share","floes","scary","bungs","smart","craps","curbs","vices","tally","beret","lenny","waked","brats","carpi","night","junes","signs","karla","dowdy","devil","toned","araby","trait","puffy","dimer","honor","moose","synch","murks","doric","muted","quite","sedan","snort","rumps","teary","heard","slice","alter","barer","whole","steep","catty","bidet","bayes","suits","dunes","jades","colin","ferry","blown","bryon","sways","bayed","fairy","bevel","pined","stoop","smear","mitty","sanes","riggs","order","palsy","reels","talon","cools","retch","olive","dotty","nanny","surat","gross","rafts","broth","mewls","craze","nerdy","barfs","johns","brims","surer","carve","beers","baker","deena","shows","fumed","horde","kicky","wrapt","waits","shane","buffy","lurks","treat","savor","wiper","bided","funny","dairy","wispy","flees","midge","hooch","sired","brett","putty","caked","witch","rearm","stubs","putts","chase","jesus","posed","dates","dosed","yawed","wombs","idles","hmong","sofas","capek","goner","musts","tangy","cheer","sinks","fatal","rubin","wrest","crank","bared","zilch","bunny","islet","spies","spent","filth","docks","notes","gripe","flair","quire","snuck","foray","cooks","godly","dorms","silos","camps","mumps","spins","cites","sulky","stink","strap","fists","tends","adobe","vivas","sulks","hasps","poser","bethe","sudan","faust","bused","plume","yoked","silly","wades","relay","brent","cower","sasha","staci","haves","dumbs","based","loser","genes","grape","lilia","acted","steel","award","mares","crabs","rocks","lines","margo","blahs","honda","rides","spine","taxed","salty","eater","bland","sweat","sores","ovens","stash","token","drink","swans","heine","gents","reads","piers","yowls","risky","tided","blips","myths","cline","tiers","racer","limed","poled","sluts","chump","greek","wines","mangy","fools","bands","smock","prowl","china","prove","oases","gilda","brews","sandy","leers","watch","tango","keven","banns","wefts","crass","cloud","hunch","cluck","reams","comic","spool","becky","grown","spike","lingo","tease","fixed","linda","bleep","funky","fanny","curve","josie","minds","musty","toxin","drags","coors","dears","beams","wooer","dells","brave","drake","merge","hippo","lodge","taper","roles","plums","dandy","harps","lutes","fails","navel","lyons","magic","walks","sonic","voles","raped","stamp","minus","hazel","clods","tiffs","hayed","rajah","pared","hates","makes","hinds","splay","flags","tempe","waifs","roved","dills","jonas","avers","balds","balks","perms","dully","lithe","aisha","witty","ellie","dived","range","lefty","wined","booby","decor","jaded","knobs","roded","moots","whens","valet","talks","blare","heeds","cuing","needy","knees","broke","bored","henna","rages","vises","perch","laded","emily","spark","tracy","tevet","faith","sweet","grays","teams","adder","miffs","tubae","marin","folds","basis","drugs","prick","tucks","fifth","treks","taney","romps","jerry","bulgy","anton","codes","bones","quota","turns","melts","croat","woken","wried","leash","spacy","bless","lager","rakes","pukes","cushy","silks","auden","dotes","hinge","noisy","coked","hiked","garth","natty","novel","peeve","macaw","sloth","warns","soles","lobed","aimee","toads","plugs","chasm","pries","douse","ruled","venus","robes","aglow","waves","swore","strum","stael","seeps","snots","freed","truck","hilly","fixer","rarer","rhyme","smugs","demos","ships","piped","jumpy","grant","dirty","climb","quell","pulps","puers","comte","kirks","waver","fever","swear","straw","serum","cowed","blent","yuppy","ropes","conks","boozy","feeds","japes","auger","noons","wench","tasty","honed","balms","trams","pasha","mummy","tides","shove","shyer","trope","clash","promo","harem","never","humus","burks","plans","tempi","crude","vocal","lames","guppy","crime","cough","rural","break","codex","baggy","camry","muses","exile","harte","evens","uriel","bombs","wrens","goren","clark","groom","tinny","alias","irwin","ruddy","twins","rears","ogden","joker","shaky","sodas","larch","lelia","longs","leeds","store","scars","plush","speck","lamar","baser","geeky","wilda","sonny","gummy","porch","grain","testy","wreck","spurs","belie","ached","vapid","chaos","brice","finks","lamed","prize","tsars","drubs","direr","shelf","ceres","swops","weirs","vader","benet","gurus","boors","mucky","gilds","pride","angus","hutch","vance","candy","pesky","favor","glenn","denim","mines","frump","surge","burro","gated","badge","snore","fires","omens","sicks","built","baits","crate","nifty","laser","fords","kneel","louse","earls","greed","miked","tunic","takes","align","robed","acres","least","sleek","motes","hales","idled","faked","bunks","biped","sowed","lucky","grunt","clear","flops","grill","pinch","bodes","delta","lopes","booms","lifer","stunk","avery","wight","flaps","yokel","burgs","racks","claus","haled","nears","finns","chore","stove","dunce","boles","askew","timid","panic","words","soupy","perks","bilge","elias","crush","pagan","silts","clive","shuck","fulls","boner","claws","panza","blurb","soaks","skips","shape","yells","raved","poppy","lease","trued","minks","estes","aisle","penes","kathy","combo","viper","chops","blend","jolly","gimpy","burma","cohan","gazer","drums","gnaws","clone","drain","morns","wages","moths","slues","slobs","warps","brand","popes","triad","ounce","stilt","shins","greer","hodge","minos","tweed","sexed","alger","floss","timer","steve","birch","known","aryan","hedge","fully","jumps","bites","shots","curer","board","lenin","corns","dough","named","kinda","truce","games","lanes","suave","leann","pesos","masks","ghats","stows","mules","hexes","chuck","alden","aping","dives","thurs","nancy","kicks","gibed","burly","sager","filly","onset","anons","yokes","tryst","rangy","pours","rotes","hided","touch","shads","tonya","finer","moors","texas","shoot","tears","elope","tills"
        };
        List<String> asList=new ArrayList<>(Arrays.asList(alist));
        testclass ts=new testclass();
        ts.topKFrequent(nums,2);
        System.out.println("Ladder length:"+ts.ladderLength(begin,end,asList));
        Interval it=new Interval(1,3);
        Interval it2=new Interval(2,6);
        Interval it3=new Interval(8,10);
        Interval it4=new Interval(15,18);
        ArrayList<Interval> list=new ArrayList<>(Arrays.asList(new Interval[]{it,it2,it3,it4}));
        ts.merge(list);
    //    ts.topKFrequent(new int[]{1},1);
        int a =0;


*/

        int[][] array=new int[][]{{1,0}};
        testclass ts=new testclass();
        ts.canFinish(2,array);

    }
}
