# Copyright (C) (2019) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
#
# This file is part of quatredesuite
#
# aquiletour is free software: you can redistribute it and/or modify
# it under the terms of the GNU Affero General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# aquiletour is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU Affero General Public License for more details.
#
# You should have received a copy of the GNU Affero General Public License
# along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

##### INCLUDE #####
this_dir=$(readlink -f $0)
scripts_dir=$(dirname "$this_dir")
. "$scripts_dir/include.sh"
###################

save_dir

signature="[[:alnum:]_]\+[[:space:]]*([^;]*)[^)]*{"

for java_file in $(find "$java_dir" -name "*.java" );
do

	sed  "/$signature/,/}/{
				/if/d
				/for/d
				/switch/d
				/new/d
				/$signature/n
				/}/n
				/J.appel/!d
 			}"  $java_file | 

 	(

 	sed "/{/{N;s/\n//}" ) | 
 	#cat -) | 

 	(

		#cat -
 		#grep  "$signature" 
 		grep  "$signature" | grep -v "J\.appel" | grep -o "$signature" | while read methode; do grep -Hn "$methode" "$java_file"; done

 	)

done


restore_dir

