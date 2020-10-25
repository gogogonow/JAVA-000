学习笔记

环境配置：
	jdk版本：openjdk version "1.8.0_265"
	系统：win10 专业版 x64
	处理器：AMD Ryzen 5 3600 6-Core Processor
	内存：32G

一、GC日志解读分析：

1、串行GC
java -XX:+UseSerialGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

	正在执行...
	【1】2020-10-25T20:17:39.650+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.650+0800: [DefNew: 139776K->17472K(157248K), 0.0136861 secs] 139776K->46852K(506816K), 0.0139114 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
	【2】2020-10-25T20:17:39.684+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.684+0800: [DefNew: 156973K->17471K(157248K), 0.0175458 secs] 186353K->92935K(506816K), 0.0178060 secs] [Times: user=0.01 sys=0.00, real=0.02 secs]
	【3】2020-10-25T20:17:39.722+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.722+0800: [DefNew: 157217K->17471K(157248K), 0.0138613 secs] 232682K->135546K(506816K), 0.0140557 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
	【4】2020-10-25T20:17:39.756+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.756+0800: [DefNew: 157247K->17470K(157248K), 0.0139438 secs] 275322K->177118K(506816K), 0.0141394 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
	【5】2020-10-25T20:17:39.791+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.791+0800: [DefNew: 157246K->17469K(157248K), 0.0126881 secs] 316894K->214476K(506816K), 0.0129089 secs] [Times: user=0.01 sys=0.00, real=0.01 secs]
	【6】2020-10-25T20:17:39.824+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.824+0800: [DefNew: 157245K->17472K(157248K), 0.0147841 secs] 354252K->259906K(506816K), 0.0150531 secs] [Times: user=0.00 sys=0.01, real=0.02 secs]
	【7】2020-10-25T20:17:39.858+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.858+0800: [DefNew: 157248K->17472K(157248K), 0.0152726 secs] 399682K->307089K(506816K), 0.0155459 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
	【8】2020-10-25T20:17:39.894+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.894+0800: [DefNew: 157248K->17470K(157248K), 0.0135207 secs] 446865K->348067K(506816K), 0.0137581 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
	【9】2020-10-25T20:17:39.927+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.927+0800: [DefNew: 156606K->156606K(157248K), 0.0001134 secs]2020-10-25T20:17:39.927+0800: [Tenured: 330596K->276896K(349568K), 0.0355878 secs] 487203K->276896K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0360581 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
	【10】2020-10-25T20:17:39.982+0800: [GC (Allocation Failure) 2020-10-25T20:17:39.982+0800: [DefNew: 139776K->17471K(157248K), 0.0075358 secs] 416672K->326835K(506816K), 0.0077857 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【11】2020-10-25T20:17:40.010+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.010+0800: [DefNew: 157247K->157247K(157248K), 0.0000946 secs]2020-10-25T20:17:40.010+0800: [Tenured: 309363K->312211K(349568K), 0.0406435 secs] 466611K->312211K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0411088 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
	【12】2020-10-25T20:17:40.071+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.071+0800: [DefNew: 139082K->139082K(157248K), 0.0000662 secs]2020-10-25T20:17:40.071+0800: [Tenured: 312211K->322351K(349568K), 0.0396819 secs] 451293K->322351K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0400973 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
	【13】2020-10-25T20:17:40.130+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.131+0800: [DefNew: 139748K->139748K(157248K), 0.0000941 secs]2020-10-25T20:17:40.131+0800: [Tenured: 322351K->318802K(349568K), 0.0451701 secs] 462099K->318802K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0456537 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
	【14】2020-10-25T20:17:40.195+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.195+0800: [DefNew: 139776K->139776K(157248K), 0.0000977 secs]2020-10-25T20:17:40.195+0800: [Tenured: 318802K->336725K(349568K), 0.0314582 secs] 458578K->336725K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0319146 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
	【15】2020-10-25T20:17:40.247+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.247+0800: [DefNew: 139609K->139609K(157248K), 0.0001511 secs]2020-10-25T20:17:40.247+0800: [Tenured: 336725K->344705K(349568K), 0.0403251 secs] 476335K->344705K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0408252 secs] [Times: user=0.03 sys=0.00, real=0.04 secs]
	【16】2020-10-25T20:17:40.306+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.306+0800: [DefNew: 139776K->139776K(157248K), 0.0000990 secs]2020-10-25T20:17:40.307+0800: [Tenured: 344705K->349116K(349568K), 0.0453637 secs] 484481K->355489K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0458966 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
	【17】2020-10-25T20:17:40.373+0800: [Full GC (Allocation Failure) 2020-10-25T20:17:40.373+0800: [Tenured: 349561K->338966K(349568K), 0.0467144 secs] 506803K->338966K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0469798 secs] [Times: user=0.05 sys=0.00, real=0.05 secs]
	【18】2020-10-25T20:17:40.440+0800: [GC (Allocation Failure) 2020-10-25T20:17:40.440+0800: [DefNew: 139776K->139776K(157248K), 0.0001009 secs]2020-10-25T20:17:40.440+0800: [Tenured: 338966K->349459K(349568K), 0.0310216 secs] 478742K->363163K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0314907 secs] [Times: user=0.03 sys=0.00, real=0.03 secs]
	【19】2020-10-25T20:17:40.491+0800: [Full GC (Allocation Failure) 2020-10-25T20:17:40.491+0800: [Tenured: 349531K->349374K(349568K), 0.0412551 secs] 506776K->364873K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0415289 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
	【20】2020-10-25T20:17:40.552+0800: [Full GC (Allocation Failure) 2020-10-25T20:17:40.553+0800: [Tenured: 349374K->349342K(349568K), 0.0441483 secs] 506565K->376837K(506816K), [Metaspace: 2837K->2837K(1056768K)], 0.0444482 secs] [Times: user=0.05 sys=0.00, real=0.04 secs]
	执行结束!共生成对象次数:10432

1秒的时间内发生十六次YGC后，进行了一次Full GC，接着进行了一次YGC，最后两次Full GC。当新生代空间不够时会触发YGC，YGC时会将新生代部分数据清除，同时将部分数据复制到S0或S1区，达到年龄阈值的数据会移到老年代。
第【1】次为例进行分析，新生代空间不足时触发YGC，新生代从139776K减少到17472K，新生代总大小为157248K，大概从89%降低到11%，花了大约13ms，整个堆空间从139776K降低到46852K，整个堆总大小为506816K，大概从27%降低到9%，花了大约14ms，
	垃圾收集线程用户态消耗的CPU时间忽略不计，内核态消耗的CPU时间为0.02s，操作开始到结束时间0.01s。
	堆空间使用减少139776K - 46852K = 92924K，新生代使用空间减少139776K - 17472K = 122304K，由此可知，有122304K - 92924K = 29380K的数据进入了S0或S1以及老年区。
第【9】次YGC中新生代中大小没有变化156606K->156606K(157248K)，应该是由于新申请的对象占用空间太大，新生代无法分配，同时满足大对象条件，所以放到老年代，并对老年代做了垃圾清理，老年代空间使用情况从330596K->276896K(349568K),大约减少了53m。
第【17】次为Full GC，由于老年代空间不足触发，老年代空间占用从349561K减少到338966K(349568K)，变化不大，堆空间占用从506803K减少到338966K(506816K)
整体趋势：随着对象增多，老年代中占用空间逐渐增大，新生代在没有垃圾清理时YGC耗时可忽略不计，有垃圾清理时耗时平均在十几毫秒，老年代垃圾回收耗时相对于新生代要高，在40ms左右。1s内一共生成10432次对象。

2、并行GC
java -XX:+UseParallelGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
	正在执行...
	【1】2020-10-25T21:32:13.891+0800: [GC (Allocation Failure) [PSYoungGen: 131584K->21495K(153088K)] 131584K->49178K(502784K), 0.0099735 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【2】2020-10-25T21:32:13.921+0800: [GC (Allocation Failure) [PSYoungGen: 153079K->21501K(153088K)] 180762K->89859K(502784K), 0.0125775 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
	【3】2020-10-25T21:32:13.954+0800: [GC (Allocation Failure) [PSYoungGen: 153085K->21502K(153088K)] 221443K->130258K(502784K), 0.0109829 secs] [Times: user=0.00 sys=0.02, real=0.01 secs]
	【4】2020-10-25T21:32:13.984+0800: [GC (Allocation Failure) [PSYoungGen: 152971K->21500K(153088K)] 261727K->172429K(502784K), 0.0113198 secs] [Times: user=0.00 sys=0.01, real=0.01 secs]
	【5】2020-10-25T21:32:14.015+0800: [GC (Allocation Failure) [PSYoungGen: 153084K->21499K(153088K)] 304013K->216606K(502784K), 0.0115371 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【6】2020-10-25T21:32:14.047+0800: [GC (Allocation Failure) [PSYoungGen: 152991K->21502K(80384K)] 348097K->252484K(430080K), 0.0097321 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【7】2020-10-25T21:32:14.065+0800: [GC (Allocation Failure) [PSYoungGen: 80153K->32866K(116736K)] 311135K->270269K(466432K), 0.0055225 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【8】2020-10-25T21:32:14.079+0800: [GC (Allocation Failure) [PSYoungGen: 91724K->45120K(116736K)] 329127K->286227K(466432K), 0.0066904 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【9】2020-10-25T21:32:14.094+0800: [GC (Allocation Failure) [PSYoungGen: 104000K->52760K(116736K)] 345107K->303475K(466432K), 0.0089701 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【10】2020-10-25T21:32:14.111+0800: [GC (Allocation Failure) [PSYoungGen: 111560K->43363K(116736K)] 362275K->325109K(466432K), 0.0108190 secs] [Times: user=0.03 sys=0.13, real=0.01 secs]
	【11】2020-10-25T21:32:14.131+0800: [GC (Allocation Failure) [PSYoungGen: 102243K->24411K(116736K)] 383989K->348069K(466432K), 0.0100643 secs] [Times: user=0.05 sys=0.11, real=0.01 secs]
	【12】2020-10-25T21:32:14.141+0800: [Full GC (Ergonomics) [PSYoungGen: 24411K->0K(116736K)] [ParOldGen: 323657K->240356K(349696K)] 348069K->240356K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0333627 secs] [Times: user=0.31 sys=0.00, real=0.03 secs]
	【13】2020-10-25T21:32:14.183+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->20107K(116736K)] 299236K->260464K(466432K), 0.0032631 secs] [Times: user=0.00 sys=0.01, real=0.00 secs]
	【14】2020-10-25T21:32:14.196+0800: [GC (Allocation Failure) [PSYoungGen: 78987K->23325K(116736K)] 319344K->282334K(466432K), 0.0059029 secs] [Times: user=0.14 sys=0.00, real=0.01 secs]
	【15】2020-10-25T21:32:14.210+0800: [GC (Allocation Failure) [PSYoungGen: 82059K->16804K(116736K)] 341068K->298576K(466432K), 0.0062499 secs] [Times: user=0.13 sys=0.00, real=0.01 secs]
	【16】2020-10-25T21:32:14.225+0800: [GC (Allocation Failure) [PSYoungGen: 75684K->19911K(116736K)] 357456K->317126K(466432K), 0.0053340 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【17】2020-10-25T21:32:14.239+0800: [GC (Allocation Failure) [PSYoungGen: 78540K->18846K(116736K)] 375756K->335210K(466432K), 0.0052721 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【18】2020-10-25T21:32:14.244+0800: [Full GC (Ergonomics) [PSYoungGen: 18846K->0K(116736K)] [ParOldGen: 316364K->264966K(349696K)] 335210K->264966K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0330425 secs] [Times: user=0.14 sys=0.00, real=0.03 secs]
	【19】2020-10-25T21:32:14.286+0800: [GC (Allocation Failure) [PSYoungGen: 58831K->24560K(116736K)] 323797K->289527K(466432K), 0.0035957 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【20】2020-10-25T21:32:14.298+0800: [GC (Allocation Failure) [PSYoungGen: 83440K->22836K(116736K)] 348407K->310886K(466432K), 0.0061695 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【21】2020-10-25T21:32:14.314+0800: [GC (Allocation Failure) [PSYoungGen: 81716K->19217K(116736K)] 369766K->329628K(466432K), 0.0056592 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【22】2020-10-25T21:32:14.320+0800: [Full GC (Ergonomics) [PSYoungGen: 19217K->0K(116736K)] [ParOldGen: 310410K->284270K(349696K)] 329628K->284270K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0346490 secs] [Times: user=0.31 sys=0.00, real=0.03 secs]
	【23】2020-10-25T21:32:14.363+0800: [GC (Allocation Failure) [PSYoungGen: 58609K->21732K(116736K)] 342880K->306003K(466432K), 0.0033391 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【24】2020-10-25T21:32:14.375+0800: [GC (Allocation Failure) [PSYoungGen: 80384K->20733K(116736K)] 364654K->324004K(466432K), 0.0060212 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【25】2020-10-25T21:32:14.390+0800: [GC (Allocation Failure) [PSYoungGen: 79613K->15299K(116736K)] 382884K->337940K(466432K), 0.0051284 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【26】2020-10-25T21:32:14.395+0800: [Full GC (Ergonomics) [PSYoungGen: 15299K->0K(116736K)] [ParOldGen: 322640K->290879K(349696K)] 337940K->290879K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0353704 secs] [Times: user=0.31 sys=0.00, real=0.04 secs]
	【27】2020-10-25T21:32:14.438+0800: [GC (Allocation Failure) [PSYoungGen: 58795K->24887K(116736K)] 349675K->315767K(466432K), 0.0036617 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【28】2020-10-25T21:32:14.451+0800: [GC (Allocation Failure) [PSYoungGen: 83767K->23342K(116736K)] 374647K->338320K(466432K), 0.0071098 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【29】2020-10-25T21:32:14.458+0800: [Full GC (Ergonomics) [PSYoungGen: 23342K->0K(116736K)] [ParOldGen: 314977K->300749K(349696K)] 338320K->300749K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0361912 secs] [Times: user=0.22 sys=0.00, real=0.04 secs]
	【30】2020-10-25T21:32:14.503+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->19966K(116736K)] 359629K->320716K(466432K), 0.0031213 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【31】2020-10-25T21:32:14.516+0800: [GC (Allocation Failure) [PSYoungGen: 78594K->19420K(116736K)] 379344K->339496K(466432K), 0.0053004 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【32】2020-10-25T21:32:14.522+0800: [Full GC (Ergonomics) [PSYoungGen: 19420K->0K(116736K)] [ParOldGen: 320076K->310852K(349696K)] 339496K->310852K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0370988 secs] [Times: user=0.31 sys=0.02, real=0.04 secs]
	【33】2020-10-25T21:32:14.568+0800: [GC (Allocation Failure) [PSYoungGen: 58880K->20076K(116736K)] 369732K->330928K(466432K), 0.0029413 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【34】2020-10-25T21:32:14.581+0800: [GC (Allocation Failure) [PSYoungGen: 78956K->36597K(116736K)] 389808K->347449K(466432K), 0.0048860 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	【35】2020-10-25T21:32:14.595+0800: [GC (Allocation Failure) [PSYoungGen: 95451K->15239K(116736K)] 406303K->361699K(466432K), 0.0081696 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	【36】2020-10-25T21:32:14.603+0800: [Full GC (Ergonomics) [PSYoungGen: 15239K->0K(116736K)] [ParOldGen: 346459K->316855K(349696K)] 361699K->316855K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0383343 secs] [Times: user=0.41 sys=0.00, real=0.04 secs]
	【37】2020-10-25T21:32:14.650+0800: [Full GC (Ergonomics) [PSYoungGen: 58841K->0K(116736K)] [ParOldGen: 316855K->324906K(349696K)] 375697K->324906K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0381634 secs] [Times: user=0.31 sys=0.00, real=0.04 secs]
	【38】2020-10-25T21:32:14.697+0800: [Full GC (Ergonomics) [PSYoungGen: 58875K->0K(116736K)] [ParOldGen: 324906K->327597K(349696K)] 383782K->327597K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0389471 secs] [Times: user=0.41 sys=0.00, real=0.04 secs]
	【39】2020-10-25T21:32:14.744+0800: [Full GC (Ergonomics) [PSYoungGen: 58880K->0K(116736K)] [ParOldGen: 327597K->331682K(349696K)] 386477K->331682K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0397466 secs] [Times: user=0.33 sys=0.00, real=0.04 secs]
	【40】2020-10-25T21:32:14.793+0800: [Full GC (Ergonomics) [PSYoungGen: 58839K->0K(116736K)] [ParOldGen: 331682K->332969K(349696K)] 390522K->332969K(466432K), [Metaspace: 2837K->2837K(1056768K)], 0.0402050 secs] [Times: user=0.30 sys=0.00, real=0.04 secs]
	执行结束!共生成对象次数:9039

由日志可以看到，并行GC在YGC过程中耗时相对于串行GC低，平均耗时大约几毫秒，在FGC过程中耗时大约三十几毫秒。整体看来Full GC的频率越来越高，最后一直在Full GC，共生成对象9039次

3、CMS
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis
贴出部分：
	正在执行...
	2020-10-25T21:43:25.872+0800: [GC (Allocation Failure) 2020-10-25T21:43:25.872+0800: [ParNew: 139776K->17469K(157248K), 0.0098316 secs] 139776K->45879K(506816K), 0.0100700 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	2020-10-25T21:43:25.903+0800: [GC (Allocation Failure) 2020-10-25T21:43:25.903+0800: [ParNew: 157245K->17472K(157248K), 0.0126003 secs] 185655K->89302K(506816K), 0.0128114 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
	2020-10-25T21:43:25.936+0800: [GC (Allocation Failure) 2020-10-25T21:43:25.937+0800: [ParNew: 157248K->17472K(157248K), 0.0157202 secs] 229078K->129483K(506816K), 0.0159392 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
	2020-10-25T21:43:25.973+0800: [GC (Allocation Failure) 2020-10-25T21:43:25.973+0800: [ParNew: 157248K->17471K(157248K), 0.0186612 secs] 269259K->176325K(506816K), 0.0189400 secs] [Times: user=0.14 sys=0.02, real=0.02 secs]
	2020-10-25T21:43:26.012+0800: [GC (Allocation Failure) 2020-10-25T21:43:26.013+0800: [ParNew: 157247K->17471K(157248K), 0.0193266 secs] 316101K->228113K(506816K), 0.0195899 secs] [Times: user=0.13 sys=0.03, real=0.02 secs]
	2020-10-25T21:43:26.032+0800: [GC (CMS Initial Mark) [1 CMS-initial-mark: 210641K(349568K)] 228376K(506816K), 0.0002410 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	2020-10-25T21:43:26.033+0800: [CMS-concurrent-mark-start]
	2020-10-25T21:43:26.034+0800: [CMS-concurrent-mark: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	2020-10-25T21:43:26.034+0800: [CMS-concurrent-preclean-start]
	2020-10-25T21:43:26.035+0800: [CMS-concurrent-preclean: 0.000/0.000 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	2020-10-25T21:43:26.035+0800: [CMS-concurrent-abortable-preclean-start]
	2020-10-25T21:43:26.054+0800: [GC (Allocation Failure) 2020-10-25T21:43:26.054+0800: [ParNew: 157247K->17471K(157248K), 0.0169640 secs] 367889K->269891K(506816K), 0.0171696 secs] [Times: user=0.14 sys=0.01, real=0.02 secs]
	2020-10-25T21:43:26.091+0800: [GC (Allocation Failure) 2020-10-25T21:43:26.091+0800: [ParNew: 157002K->17470K(157248K), 0.0149814 secs] 409422K->308523K(506816K), 0.0152009 secs] [Times: user=0.14 sys=0.02, real=0.01 secs]
	2020-10-25T21:43:26.125+0800: [GC (Allocation Failure) 2020-10-25T21:43:26.126+0800: [ParNew: 157246K->17471K(157248K), 0.0186091 secs] 448299K->359064K(506816K), 0.0188612 secs] [Times: user=0.16 sys=0.00, real=0.02 secs]
	2020-10-25T21:43:26.144+0800: [CMS-concurrent-abortable-preclean: 0.003/0.110 secs] [Times: user=0.50 sys=0.03, real=0.11 secs]
	2020-10-25T21:43:26.145+0800: [GC (CMS Final Remark) [YG occupancy: 21100 K (157248 K)]2020-10-25T21:43:26.145+0800: [Rescan (parallel) , 0.0002425 secs]2020-10-25T21:43:26.145+0800: [weak refs processing, 0.0000729 secs]2020-10-25T21:43:26.145+0800: [class unloading, 0.0002817 secs]2020-10-25T21:43:26.145+0800: [scrub symbol table, 0.0005005 secs]2020-10-25T21:43:26.146+0800: [scrub string table, 0.0001171 secs][1 CMS-remark: 341593K(349568K)] 362693K(506816K), 0.0015145 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	2020-10-25T21:43:26.146+0800: [CMS-concurrent-sweep-start]
	2020-10-25T21:43:26.147+0800: [CMS-concurrent-sweep: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	2020-10-25T21:43:26.147+0800: [CMS-concurrent-reset-start]
	2020-10-25T21:43:26.148+0800: [CMS-concurrent-reset: 0.001/0.001 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
	。。。。。。。。。。。
	执行结束!共生成对象次数:11066

由日志可以看到，CMS需要初始标记（STW）、并发标记、并发预清理、并发可中止的预清理阶段、最终标记（STW）、并发清除、并发重置几个步骤，各操作耗时相较于并行GC更低，共生成对象11066次。

4、G1
java -XX:+UseG1GC -Xms512m -Xmx512m -XX:+PrintGCDetails -XX:+PrintGCDateStamps GCLogAnalysis

贴一部分：
	正在执行...
	【1】2020-10-25T21:57:25.142+0800: [GC pause (G1 Evacuation Pause) (young), 0.0022910 secs]
	   [Parallel Time: 1.7 ms, GC Workers: 10]
		  [GC Worker Start (ms): Min: 83.5, Avg: 83.5, Max: 83.5, Diff: 0.1]
		  [Ext Root Scanning (ms): Min: 0.1, Avg: 0.2, Max: 0.3, Diff: 0.1, Sum: 1.8]
		  [Update RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
			 [Processed Buffers: Min: 0, Avg: 0.0, Max: 0, Diff: 0, Sum: 0]
		  [Scan RS (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
		  [Code Root Scanning (ms): Min: 0.0, Avg: 0.0, Max: 0.0, Diff: 0.0, Sum: 0.0]
		  [Object Copy (ms): Min: 1.2, Avg: 1.2, Max: 1.3, Diff: 0.1, Sum: 12.5]
		  [Termination (ms): Min: 0.0, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.7]
			 [Termination Attempts: Min: 1, Avg: 1.0, Max: 1, Diff: 0, Sum: 10]
		  [GC Worker Other (ms): Min: 0.1, Avg: 0.1, Max: 0.1, Diff: 0.1, Sum: 0.9]
		  [GC Worker Total (ms): Min: 1.6, Avg: 1.6, Max: 1.6, Diff: 0.1, Sum: 16.0]
		  [GC Worker End (ms): Min: 85.1, Avg: 85.1, Max: 85.1, Diff: 0.0]
	   [Code Root Fixup: 0.0 ms]
	   [Code Root Purge: 0.0 ms]
	   [Clear CT: 0.1 ms]
	   [Other: 0.5 ms]
		  [Choose CSet: 0.0 ms]
		  [Ref Proc: 0.1 ms]
		  [Ref Enq: 0.0 ms]
		  [Redirty Cards: 0.1 ms]
		  [Humongous Register: 0.0 ms]
		  [Humongous Reclaim: 0.0 ms]
		  [Free CSet: 0.0 ms]
	【2】   [Eden: 25600.0K(25600.0K)->0.0B(26624.0K) Survivors: 0.0B->4096.0K Heap: 30425.5K(512.0M)->8858.0K(512.0M)]
	 [Times: user=0.00 sys=0.00, real=0.00 secs]

	。。。。。。。。。。。。。。。。

	执行结束!共生成对象次数:10494

【1】中young为GC类型，表示年轻代GC，耗时2ms；有10个GC Workers（线程）负责垃圾收集，线程个数跟CPU有关，如果物理CPU支持的线程个数小于8，则最多设置为8；如果物理CPU支持的线程个数大于8，则默认值为num*5/8；
下面为各个操作时间信息min、max、avg以及diff；
【2】中可以看到新生代大小为26624K，占用25600K，即可判断此次GC是新生代空间不足导致，处理后占用空间变为0K，由于新生代回收处理，Survivors区增加，整个堆空间大小为512m，占用空间从30425K减少到8858K。
共生成对象次数:10494


调整堆空间大小参数，调整为512G：
1、串行GC
执行结束!共生成对象次数:10432
2、并行GC
执行结束!共生成对象次数:9039
3、CMS
执行结束!共生成对象次数:11066
4、G1
执行结束!共生成对象次数:10494


调整堆空间大小参数，调整为4G：
1、串行GC
执行结束!共生成对象次数:16714
2、并行GC
执行结束!共生成对象次数:16385
3、CMS
执行结束!共生成对象次数:15482
4、G1
执行结束!共生成对象次数:16133


调整堆空间大小参数，调整为8G：
1、串行GC
执行结束!共生成对象次数:14089
2、并行GC
执行结束!共生成对象次数:15728
3、CMS
执行结束!共生成对象次数:15533
4、G1
执行结束!共生成对象次数:16861


调整堆空间大小参数，调整为16G：
1、串行GC
执行结束!共生成对象次数:12295
2、并行GC
执行结束!共生成对象次数:12097
3、CMS
执行结束!共生成对象次数:14388
4、G1
执行结束!共生成对象次数:16968


总结：
1、整体看来在分配堆空间较小时，并行、串行、CMS、G1算法创建对象个数相差不大，当堆空间变大，CMS和G1的优势要明显一些
2、从串行->并行->CMS->G1，在GC时消耗时间越来越低，因为并行和CMS相对于串行支持应用程序和GC线程并发，而G1将堆空间分为更小区进行处理，类似于降低了锁的粒度，当只需要清空某个区时不会影响其他区的数据

二、压测工具演练
(sb -u http://localhost:8088/api/hello -c 20 -N 30)

1、使用默认并行GC

（1）java -jar -Xms4g -Xmx4g .\gateway-server-0.0.1-SNAPSHOT.jar

RPS: 8027.5 (requests/second)
Max: 130ms
Min: 0ms
Avg: 0ms


（2）java -jar -Xms1g -Xmx1g .\gateway-server-0.0.1-SNAPSHOT.jar

RPS: 8075.3 (requests/second)
Max: 38ms
Min: 0ms
Avg: 0ms


（3）java -jar -Xms512m -Xmx512m .\gateway-server-0.0.1-SNAPSHOT.jar

RPS: 7975 (requests/second)
Max: 186ms
Min: 0ms
Avg: 0.1ms


（4）java -jar -Xms128m -Xmx128m .\gateway-server-0.0.1-SNAPSHOT.jar

RPS: 7982.7 (requests/second)
Max: 135ms
Min: 0ms
Avg: 0.1ms


2、使用串行GC

（1）java -jar -XX:+UseSerialGC -Xms512m -Xmx512m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7963.2 (requests/second)
Max: 128ms
Min: 0ms
Avg: 0.1ms


（2）java -jar -XX:+UseSerialGC -Xms128m -Xmx128m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7942.2 (requests/second)
Max: 174ms
Min: 0ms
Avg: 0.1ms

（3）java -jar -XX:+UseSerialGC -Xms1g -Xmx1g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7936.3 (requests/second)
Max: 123ms
Min: 0ms
Avg: 0ms

（4）java -jar -XX:+UseSerialGC -Xms4g -Xmx4g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7914.8 (requests/second)
Max: 127ms
Min: 0ms
Avg: 0.1ms

3、使用CMS

（1）java -jar -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7898 (requests/second)
Max: 137ms
Min: 0ms
Avg: 0ms

（2）java -jar -XX:+UseConcMarkSweepGC -Xms128m -Xmx128m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7814.8 (requests/second)
Max: 128ms
Min: 0ms
Avg: 0.1ms

（3）java -jar -XX:+UseConcMarkSweepGC -Xms1g -Xmx1g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7982.7 (requests/second)
Max: 123ms
Min: 0ms
Avg: 0.1ms

（4）java -jar -XX:+UseConcMarkSweepGC -Xms4g -Xmx4g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7979.7 (requests/second)
Max: 128ms
Min: 0ms
Avg: 0.1ms

3、使用G1

（1）java -jar -XX:+UseG1GC -Xms512m -Xmx512m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7977.1 (requests/second)
Max: 150ms
Min: 0ms
Avg: 0.1ms

（2）java -jar -XX:+UseG1GC -Xms128m -Xmx128m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 8077.8 (requests/second)
Max: 149ms
Min: 0ms
Avg: 0ms

（3）java -jar -XX:+UseG1GC -Xms1g -Xmx1g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7937.5 (requests/second)
Max: 148ms
Min: 0ms
Avg: 0.1ms

（4）java -jar -XX:+UseG1GC -Xms4g -Xmx4g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 7930.9 (requests/second)
Max: 154ms
Min: 0ms
Avg: 0.1ms

可以发现，调整垃圾回收算法对20个并发请求数量级来说，压测的RPS基本都差不多，都能达到8000左右

调整并发请求数为100：
sb -u http://localhost:8088/api/hello -c 100 -N 30
（1）java -jar -XX:+UseSerialGC -Xms4g -Xmx4g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 2777.2 (requests/second)
Max: 171ms
Min: 0ms
Avg: 10.2ms

（2）java -jar -XX:+UseG1GC -Xms4g -Xmx4g .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 2873.6 (requests/second)
Max: 236ms
Min: 0ms
Avg: 8.4ms

（3）java -jar -XX:+UseConcMarkSweepGC -Xms128m -Xmx128m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 2917.6 (requests/second)
Max: 191ms
Min: 0ms

（4）java -jar -XX:+UseSerialGC -Xms128m -Xmx128m .\gateway-server-0.0.1-SNAPSHOT.jar
RPS: 2801.2 (requests/second)
Max: 201ms
Min: 0ms

可以发现增大并发数到100相较于20的并发数会导致RPS降低，同时导致请求响应时间增加，而垃圾回收算法对其影响不大，相对来说堆空间较大时，G1回收算法RPS高于串行算法，堆空间较小时，CMS算法优于串行算法