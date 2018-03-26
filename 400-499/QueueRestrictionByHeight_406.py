class Solution(object):
  def reconstructQueue(self, people):
    people.sort(key = lambda (h, k): (-h, k))
    '''
    sort the people from heigher to shorter
    when it comes to same height, sort by number higher or equal to them
    '''
    result = []
    for p in people:
      result.insert(p[1], p)
    '''
    create new queue, because k only represent the number higher/same, 
    we deal with them first, and the shorter ones doesn't effect the previous result
    python: list.insert(index, object) and it means before index
    '''
    return result
