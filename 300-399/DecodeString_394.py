class Solution(object):
    def decodeString(self, s):
        if s:
            times = 0
            start = []
            t = []
            line = []
            '''
            Times represent the times of repeatitions.
            We use line to record the string(characters), and when we encounter '[' we take note of the start position in string.
            when encounter ']', we make change to line and make the repetion happen for the latest [] pair.
            '''
            for i in xrange(len(s)):
                c = s[i]
                if c in ['0','1','2','3','4','5','6','7','8','9']:
                    times = times * 10 + int(c)
                elif c == '[':
                    start += [len(line)]
                    t.append(times)
                    times = 0
                elif c == ']':
                    left = start.pop()
                    newline = line[:left] + line[left:] * t.pop()
                    line = newline
                else:
                    line.append(c)                    
            return ''.join(line)
        return ''
